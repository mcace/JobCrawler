package com.mcsoft.dao;

import com.mcsoft.bean.lagou.json.content.positionResult.LagouPositionInfo;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * 拉钩职位信息DAO
 * Created by Mc on 2017/12/14.
 */
@Repository
public class LagouPositionInfoDaoImpl extends BaseDaoImpl<LagouPositionInfo> implements
        LagouPositionInfoDao {

    @Override
    public LagouPositionInfo findById(Serializable id) {
        return super.findById(LagouPositionInfo.class, id);
    }

    @Override
    public void deleteById(Serializable id) {
        super.deleteById(LagouPositionInfo.class, id);
    }

    @Override
    public void setProcessed(int postionId) {
        LagouPositionInfo info = this.findById(LagouPositionInfo.class, postionId);
        if (null != info && new Integer(0).equals(info.getProcessed())) {
            info.setProcessed(1);
            this.update(info);
        }
    }
}
