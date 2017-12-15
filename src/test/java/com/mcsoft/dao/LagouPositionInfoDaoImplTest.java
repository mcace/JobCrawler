package com.mcsoft.dao;

import com.mcsoft.bean.lagou.json.content.positionResult.LagouPositionInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Mc on 2017/12/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
@Transactional
@Rollback(true)
public class LagouPositionInfoDaoImplTest {
    @Resource
    private LagouPositionInfoDao lagouPositionInfoDao;

    @Test
    public void save() {
        LagouPositionInfo info = new LagouPositionInfo();
        info.setPositionId(0);
        System.out.println(lagouPositionInfoDao.save(info));
        LagouPositionInfo info1 = lagouPositionInfoDao.findById(0);
        assert null != info1;
        System.out.println(info1.getId());


     }

    @Test
    public void setProcessed() throws Exception {
        save();
        lagouPositionInfoDao.setProcessed(0);
        LagouPositionInfo info = lagouPositionInfoDao.findById(0);
        assert 1 == info.getProcessed();
    }

    @Test
    public void delete() {
        save();
        lagouPositionInfoDao.deleteById(0);
        LagouPositionInfo info = lagouPositionInfoDao.findById(0);
        assert null == info;
    }

    @Test
    public void update() {
        save();
        LagouPositionInfo info = lagouPositionInfoDao.findById(0);
        info.setBusinessZones("ddd");
        lagouPositionInfoDao.update(info);
        LagouPositionInfo info1 = lagouPositionInfoDao.findById(0);
        assert "ddd".equals(info1.getBusinessZones());
    }

    @Test
    public void batchSave() {

    }
}