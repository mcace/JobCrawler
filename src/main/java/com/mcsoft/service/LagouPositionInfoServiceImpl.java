package com.mcsoft.service;

import com.mcsoft.bean.lagou.json.content.positionResult.LagouPositionInfo;
import com.mcsoft.dao.LagouPositionInfoDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 拉钩职位信息service层实现类
 * Created by Mc on 2017/12/15.
 */
@Service
@Transactional
public class LagouPositionInfoServiceImpl implements LagouPositionInfoService {
    @Resource
    private LagouPositionInfoDao lagouPositionInfoDao;

    @Override
    public void saveOrUpdate(LagouPositionInfo obj) {
        lagouPositionInfoDao.saveOrUpdate(obj);
    }

    @Override
    public void batchSaveOrUpdate(LagouPositionInfo[] objs) {
        lagouPositionInfoDao.batchSaveOrUpdate(objs);
    }
}
