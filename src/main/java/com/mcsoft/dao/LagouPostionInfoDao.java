package com.mcsoft.dao;

import com.mcsoft.bean.lagou.json.content.positionResult.LagouPositionInfo;

/**
 * 拉钩职位信息DAO接口
 * Created by Mc on 2017/12/14.
 */
public interface LagouPostionInfoDao extends BaseDao<LagouPositionInfo>{
    /**
     * 将对应职位id的数据设为已处理
     * @param postionId 职位id
     */
    void setProcessed(int postionId);
}
