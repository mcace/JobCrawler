package com.mcsoft.service;

import com.mcsoft.bean.lagou.LagouCompanyInfo;
import com.mcsoft.bean.lagou.LagouInterviewExperience;
import com.mcsoft.bean.lagou.LagouPositionDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 爬取职位详情Service，主要是整合多个service的事务
 * Created by Mc on 2017/12/25.
 */
@Service
@Transactional
public class LagouSecondService {
    @Resource
    private LagouCompanyInfoService companyInfoService;
    @Resource
    private LagouPositionDetailService positionDetailService;
    @Resource
    private LagouInterviewExperienceService interviewExperienceService;
    @Resource
    private LagouPositionInfoService positionInfoService;

    public void persistData(int positionId, LagouCompanyInfo companyInfo, LagouPositionDetail
            positionDetail, LagouInterviewExperience[] interviewExperiences) {
        companyInfoService.save(companyInfo);
        positionDetailService.save(positionDetail);
        interviewExperienceService.batchSaveOrUpdate(interviewExperiences);
        positionInfoService.setProcessed(positionId);
    }

}
