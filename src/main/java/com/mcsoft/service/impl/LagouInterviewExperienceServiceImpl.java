package com.mcsoft.service.impl;

import com.mcsoft.bean.lagou.LagouInterviewExperience;
import com.mcsoft.dao.LagouInterviewExperienceDao;
import com.mcsoft.service.LagouInterviewExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 拉勾网面试反馈Service接口实现类
 * Created by Mc on 2017/12/25.
 */
@Service
@Transactional
public class LagouInterviewExperienceServiceImpl extends BaseServiceImpl<LagouInterviewExperience>
        implements LagouInterviewExperienceService{
    @Autowired
    public LagouInterviewExperienceServiceImpl(LagouInterviewExperienceDao dao) {
        super(dao);
    }
}
