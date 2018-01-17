package com.mcsoft.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mcsoft.bean.lagou.LagouCompanyInfo;
import com.mcsoft.bean.lagou.LagouInterviewExperience;
import com.mcsoft.bean.lagou.LagouPositionDetail;
import com.mcsoft.bean.lagou.LagouPositionList;
import com.mcsoft.bean.lagou.params.LagouFormParam;
import com.mcsoft.bean.lagou.params.LagouInterviewParam;
import com.mcsoft.bean.lagou.params.LagouURLParam;
import com.mcsoft.bean.lagou.positionList.content.positionResult.LagouPositionInfo;
import com.mcsoft.crawler.AjaxCrawler;
import com.mcsoft.crawler.HtmlJSoupCrawler;
import com.mcsoft.service.*;
import com.mcsoft.utils.ConfigLoader;
import com.mcsoft.utils.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 拉勾网数据爬取主要Service实现类
 * Created by Mc on 2018/1/17.
 */
@Service
@Transactional
public class LagouHandleServiceImpl implements LagouHandleService {
    @Resource
    private LagouPositionInfoService positionInfoService;
    @Resource
    private LagouCompanyInfoService companyInfoService;
    @Resource
    private LagouPositionDetailService positionDetailService;
    @Resource
    private LagouInterviewExperienceService interviewExperienceService;

    @Override
    public void firstStep() {
        //爬取一级页面JSON数据
        AjaxCrawler<LagouPositionList> crawler = new AjaxCrawler<>(ConfigLoader
                .loadLagouAjaxHeaders(), LagouPositionList.class);
        int sleepTime;
        for (int maxPn = 1, pn = 1; pn <= maxPn; pn++) {
            sleepTime = 10000;
            System.out.println("当前页：" + pn);
            LagouFormParam body = new LagouFormParam();
            body.setPn(String.valueOf(pn));
            LagouPositionList json;
            try {
                json = crawler.craw(Constants.getLagouPositionAjaxUrl(LagouURLParam
                        .defaultURLParams()), body.toFormParam());
                if (!json.isSuccess()) {
                    //如果是json返回错误，可能是爬取太频繁了，休息60秒
                    sleepTime = 60000;
                    throw new Exception("在" + pn + "页被干掉了，准备休息60秒");
                }
            } catch (Exception e) {
                //处理会发生的未知错误，懒得重启和重新设置页码了
                e.printStackTrace();
                pn--;
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                continue;
            }
            LagouPositionInfo[] results = json.getContent().getPositionResult().getResult();
            positionInfoService.batchSaveOrUpdate(results);
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

    @Override
    public void secondStep() {
        //下面是实体类
        LagouPositionInfo positionInfo;
        LagouCompanyInfo companyInfo = new LagouCompanyInfo();
        LagouPositionDetail positionDetail = new LagouPositionDetail();

        //下面是抓取的url
        String interviewURL = Constants.LAGOU_POSITION_INTERVIEW_EXP_URL;
        String positionDetailURL;
        //下面是抓取配置
        String body;
        Map<String, String> positionDetailRules = ConfigLoader.loadLagouPositionDetailRules();
        Map<String, String> htmlHeaders = ConfigLoader.loadLagouHtmlHeaders();
        Map<String, String> ajaxHeaders = ConfigLoader.loadLagouAjaxHeaders();
        //下面是抓取出的数据
        JSONObject interviewExperienceJSONObject;
        Map<String, String> positionDetailCrawledMap;
        //下面是抓取的爬虫
        HtmlJSoupCrawler positionDetailCrawler = new HtmlJSoupCrawler(htmlHeaders, positionDetailRules);
        AjaxCrawler<JSONObject> interviewCrawler = new AjaxCrawler<>(ajaxHeaders, JSONObject.class);

        //用该变量记录发生错误的id，如果一个id发生3次错误，那么就将该职位的processed设为1，表示跳过处理
        int errorId = 0;
        int errorTime = 0;
        int positionId = 0;
        //下面开始处理程序
        while ((positionInfo = positionInfoService.findOneUnprocessed()) != null) {
            try {
                positionId = positionInfo.getPositionId();
                positionDetailURL = Constants.getPositionUrl(String.valueOf(positionId));

                System.out.println("当前处理职位id:" + positionId);

                try {
                    positionDetailCrawledMap = positionDetailCrawler.craw(positionDetailURL);
                    body = LagouInterviewParam.toFormParam(positionId);
                    interviewExperienceJSONObject = interviewCrawler.craw(interviewURL, body);

                    //处理抓取错误
                    if (!interviewExperienceJSONObject.get("state").equals(1)) {
                        throw new Exception("面试信息ajax错误，数据：" + interviewExperienceJSONObject.toJSONString());
                    }
                } catch (Exception e) {
                    throw new Exception("职位ID：" + positionId + " 处理时出现错误", e);
                }

                //设定公司信息
                companyInfo.setCompanyId(positionInfo.getCompanyId());
                companyInfo.setBusinessZones(positionInfo.getBusinessZones());
                companyInfo.setCompanyFullName(positionInfo.getCompanyFullName());
                companyInfo.setCompanyShortName(positionInfo.getCompanyShortName());
                companyInfo.setCompanyLabelList(positionInfo.getCompanyLabelList());
                companyInfo.setCompanySize(positionInfo.getCompanySize());
                companyInfo.setDistrict(positionInfo.getDistrict());
                companyInfo.setFinanceStage(positionInfo.getFinanceStage());
                companyInfo.setIndustryField(positionInfo.getIndustryField());
                companyInfo.setIndustryLabels(positionInfo.getIndustryLables());
                companyInfo.setLineStation(positionInfo.getLinestaion());
                companyInfo.setStationName(positionInfo.getStationname());
                companyInfo.setSubwayLine(positionInfo.getSubwayline());
                companyInfo.setCompanyLogo(positionInfo.getCompanyLogo());
                //设定职位详情
                positionDetail.setPositionId(positionInfo.getPositionId());
                positionDetail.setCreateTime(positionInfo.getCreateTime());
                positionDetail.setCity(positionInfo.getCity());
                positionDetail.setCompanyId(positionInfo.getCompanyId());
                positionDetail.setEducation(positionInfo.getEducation());
                positionDetail.setFirstType(positionInfo.getFirstType());
                positionDetail.setPositionLabels(positionInfo.getPositionLables());
                positionDetail.setPositionNature(positionInfo.getJobNature());
                positionDetail.setSalary(positionInfo.getSalary());
                positionDetail.setSecondType(positionInfo.getSecondType());
                positionDetail.setWorkYear(positionInfo.getWorkYear());

                //处理抓取出的数据
                positionDetail.setPositionName(positionDetailCrawledMap.get("positionName"));
                positionDetail.setPositionAdvantage(positionDetailCrawledMap.get("positionAdvantage"));
                positionDetail.setPositionAddress(positionDetailCrawledMap.get("positionAddress"));
                positionDetail.setPositionDescription(positionDetailCrawledMap.get("positionDescription"));
                positionDetail.setCompany(positionDetailCrawledMap.get("company"));
                companyInfo.setCompanyHref(positionDetailCrawledMap.get("companyHref"));

                interviewExperienceJSONObject = (JSONObject) interviewExperienceJSONObject.get("content");
                interviewExperienceJSONObject = (JSONObject) interviewExperienceJSONObject.get("data");
                interviewExperienceJSONObject = (JSONObject) interviewExperienceJSONObject.get("data");
                JSONArray experienceArray = (JSONArray) interviewExperienceJSONObject.get("result");
                List<LagouInterviewExperience> interviewExperienceList = new ArrayList<>();
                for (Object experience : experienceArray) {
                    interviewExperienceList.add(JSON.parseObject(experience.toString(),
                            LagouInterviewExperience.class));
                }

                //持久化数据
                companyInfoService.save(companyInfo);
                positionDetailService.save(positionDetail);
                interviewExperienceService.batchSaveOrUpdate(
                        interviewExperienceList.toArray(new
                                LagouInterviewExperience[interviewExperienceList.size()]));
                positionInfoService.setProcessed(positionId);
                //休息10秒，老被认为是机器人
                Thread.sleep(10000);
            } catch (Exception e) {
                //懒得重启程序了，有啥问题直接打印继续干吧，反正不会出大毛病
                e.printStackTrace();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                //下面是0-3次相同职位id出现错误处理部分
                if (errorId != positionId) {
                    errorId = positionId;
                    errorTime = 0;
                } else if (errorTime == 3) {
                    positionInfoService.setProcessed(positionId);
                } else {
                    errorTime++;
                }
            }
        }
    }
}
