package com.mcsoft;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mcsoft.bean.lagou.LagouCompanyInfo;
import com.mcsoft.bean.lagou.LagouInterviewExperience;
import com.mcsoft.bean.lagou.LagouPositionDetail;
import com.mcsoft.bean.lagou.params.LagouInterviewParam;
import com.mcsoft.bean.lagou.positionList.content.positionResult.LagouPositionInfo;
import com.mcsoft.crawler.AjaxCrawler;
import com.mcsoft.crawler.HtmlJSoupCrawler;
import com.mcsoft.service.*;
import com.mcsoft.utils.ConfigLoader;
import com.mcsoft.utils.Constants;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 拉勾网数据处理入口
 * Created by Mc on 2017/12/21.
 */
public class LagouSecondMain {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        LagouPositionInfoService positionInfoService = context.getBean(LagouPositionInfoService
                .class);
        LagouSecondService secondService = context.getBean(LagouSecondService.class);

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

        //下面开始处理程序
        while ((positionInfo = positionInfoService.findOneUnprocessed()) != null) {
            try {
                int positionId = positionInfo.getPositionId();
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
                secondService.persistData(positionId, companyInfo, positionDetail,
                        interviewExperienceList.toArray(new
                                LagouInterviewExperience[interviewExperienceList.size()]));
                //休息10秒，老被认为是机器人
                Thread.sleep(10000);
            } catch (Exception e) {
                //懒得重启程序了，有啥问题直接打印继续干吧，反正不会出大毛病
                e.printStackTrace();
                Thread.sleep(10000);
            }
        }
    }
}

