package com.mcsoft;

import com.mcsoft.bean.lagou.LagouCompanyInfo;
import com.mcsoft.bean.lagou.LagouInterviewExperience;
import com.mcsoft.bean.lagou.LagouPositionDetail;
import com.mcsoft.service.LagouCompanyInfoService;
import com.mcsoft.service.LagouInterviewExperienceService;
import com.mcsoft.service.LagouPositionDetailService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mc on 2017/12/25.
 */
public class LagouSecondMainTest {
    @Test
    public void main() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        LagouCompanyInfoService service = context.getBean(LagouCompanyInfoService.class);
//        LagouPositionInfoService infoService = context.getBean(LagouPositionInfoService.class);
        LagouCompanyInfo info = new LagouCompanyInfo();
        info.setCompanyId(123);
        service.save(info);

        LagouPositionDetailService positionDetailService = context.getBean
                (LagouPositionDetailService.class);
        LagouPositionDetail detail = new LagouPositionDetail();
        detail.setPositionId(123);
        positionDetailService.save(detail);

        LagouInterviewExperienceService experienceService = context.getBean
                (LagouInterviewExperienceService.class);
        LagouInterviewExperience experience = new LagouInterviewExperience();
        experience.setId(123);
        experienceService.save(experience);
    }

}