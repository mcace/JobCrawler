package com.mcsoft;

import com.mcsoft.bean.lagou.params.LagouFormParam;
import com.mcsoft.bean.lagou.LagouPositionList;
import com.mcsoft.bean.lagou.params.LagouURLParam;
import com.mcsoft.bean.lagou.positionList.content.positionResult.LagouPositionInfo;
import com.mcsoft.crawler.AjaxCrawler;
import com.mcsoft.service.LagouPositionInfoService;
import com.mcsoft.utils.ConfigLoader;
import com.mcsoft.utils.Constants;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static com.mcsoft.utils.Constants.METHOD_POST;

/**
 * 拉钩抓取main方法
 * Created by Mc on 2017/12/9.
 */
public class LagouFirstMain {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        LagouPositionInfoService infoService = context.getBean(LagouPositionInfoService.class);
        //爬取一级页面JSON数据
        int pn = 141;
        int maxPn = 200;
        AjaxCrawler<LagouPositionList> crawler = new AjaxCrawler<>(METHOD_POST, null, ConfigLoader
                .loadLagouAjaxHeaders(), LagouPositionList.class);
        for (; pn <= maxPn; pn++) {
            System.out.println("当前页：" + pn);
            LagouFormParam body = new LagouFormParam();
            body.setPn(String.valueOf(pn));
            crawler.setBody(body.toFormParam());
            LagouPositionList json = crawler.craw(Constants.getLagouAjaxUrl(LagouURLParam.defaultURLParams
                    ()));
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
//            for (LagouPositionInfo result : results) {
//                try {
//                    infoService.saveOrUpdate(result);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
            try {
                //休息10秒再继续爬，避免被ban
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
