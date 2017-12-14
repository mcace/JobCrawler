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
@Rollback(false)
public class LagouPositionInfoDaoImplTest {
    @Resource
    private LagouPostionInfoDao lagouPostionInfoDao;

    @Test
    public void save() {
        LagouPositionInfo info = new LagouPositionInfo();
        info.setPositionId(3);
        info.setBusinessZones("d");

        System.out.println(lagouPostionInfoDao.update(info));
        info.setPositionId(4);
        System.out.println(lagouPostionInfoDao.save(info));
    }

    @Test
    public void setProcessed() throws Exception {


    }

}