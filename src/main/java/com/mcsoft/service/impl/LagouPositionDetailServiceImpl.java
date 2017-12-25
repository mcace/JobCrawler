package com.mcsoft.service.impl;

import com.mcsoft.bean.lagou.LagouPositionDetail;
import com.mcsoft.dao.LagouPositionDetailDao;
import com.mcsoft.service.LagouPositionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 拉勾网职位详情Service接口实现类
 * Created by Mc on 2017/12/25.
 */
@Service
@Transactional
public class LagouPositionDetailServiceImpl extends BaseServiceImpl<LagouPositionDetail> implements
        LagouPositionDetailService {
    @Autowired
    public LagouPositionDetailServiceImpl(LagouPositionDetailDao dao) {
        super(dao);
    }
}
