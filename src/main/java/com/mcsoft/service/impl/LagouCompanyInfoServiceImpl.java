package com.mcsoft.service.impl;

import com.mcsoft.bean.lagou.LagouCompanyInfo;
import com.mcsoft.dao.LagouCompanyInfoDao;
import com.mcsoft.service.LagouCompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 拉勾网公司信息Service接口实现类
 * Created by Mc on 2017/12/25.
 */
@Service
@Transactional
public class LagouCompanyInfoServiceImpl extends BaseServiceImpl<LagouCompanyInfo> implements LagouCompanyInfoService {
    @Autowired
    public LagouCompanyInfoServiceImpl(LagouCompanyInfoDao dao) {
        super(dao);
    }
}
