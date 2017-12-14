package com.mcsoft.dao;

import com.mcsoft.bean.lagou.json.content.positionResult.LagouPositionInfo;
import org.springframework.stereotype.Repository;

/**
 * 拉钩职位信息DAO
 * Created by Mc on 2017/12/14.
 */
@Repository
public class LagouPositionInfoDaoImplImpl extends BaseDaoImpl<LagouPositionInfo> implements LagouPostionInfoDao {

    @Override
    public void setProcessed(int postionId) {
        LagouPositionInfo info = this.findById(LagouPositionInfo.class, postionId);
        if (null != info && new Integer(0).equals(info.getProcessed())) {
            info.setProcessed(1);
            this.update(info);
        }
    }
}
