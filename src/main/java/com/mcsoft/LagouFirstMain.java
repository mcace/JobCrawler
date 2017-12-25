package com.mcsoft;

import com.mcsoft.bean.lagou.LagouPositionList;
import com.mcsoft.bean.lagou.params.LagouFormParam;
import com.mcsoft.bean.lagou.params.LagouURLParam;
import com.mcsoft.bean.lagou.positionList.content.positionResult.LagouPositionInfo;
import com.mcsoft.crawler.AjaxCrawler;
import com.mcsoft.service.LagouPositionInfoService;
import com.mcsoft.utils.ConfigLoader;
import com.mcsoft.utils.Constants;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 拉钩抓取main方法
 * Created by Mc on 2017/12/9.
 */
public class LagouFirstMain {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        LagouPositionInfoService infoService = context.getBean(LagouPositionInfoService.class);
        //爬取一级页面JSON数据
        AjaxCrawler<LagouPositionList> crawler = new AjaxCrawler<>(ConfigLoader
                .loadLagouAjaxHeaders(), LagouPositionList.class);
        for (int maxPn = 1, pn = 1; pn <= maxPn; pn++) {
            System.out.println("当前页：" + pn);
            LagouFormParam body = new LagouFormParam();
            body.setPn(String.valueOf(pn));
            LagouPositionList json;
            try {
                json = crawler.craw(Constants.getLagouPositionAjaxUrl(LagouURLParam
                        .defaultURLParams()), body.toFormParam());
            } catch (Exception e) {
                //处理会发生的未知错误，懒得重启和重新设置页码了
                e.printStackTrace();
                pn--;
                Thread.sleep(10000);
                continue;
            }
            if (!json.isSuccess()) {
//                System.err.println("发生错误");
//                try {
//                    Thread.sleep(20000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                throw new Exception("在" + pn + "页被干掉了");
            }
            LagouPositionInfo[] results = json.getContent().getPositionResult().getResult();
            infoService.batchSaveOrUpdate(results);
            try {
                //休息10秒再继续爬，避免被ban
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (maxPn <= pn) {
                maxPn = Double.valueOf(Math.ceil(json.getContent().getPositionResult().getTotalCount()
                        / (double) json.getContent().getPageSize())).intValue();
            }
        }
    }
}
