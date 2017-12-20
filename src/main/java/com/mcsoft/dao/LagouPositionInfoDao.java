package com.mcsoft.dao;

import com.mcsoft.bean.lagou.positionList.content.positionResult.LagouPositionInfo;

import java.io.Serializable;

/**
 * 拉钩职位信息DAO接口
 * Created by Mc on 2017/12/14.
 */
public interface LagouPositionInfoDao extends BaseDao<LagouPositionInfo>{
    /**
     * 根据ID查找数据
     * @param id 数据ID
     * @return 数据条目
     */
    LagouPositionInfo findById(Serializable id);

    /**
     * 根据ID删除数据
     * @param id 数据ID
     */
    void deleteById(Serializable id);

    /**
     * 将对应职位id的数据设为已处理
     * @param postionId 职位id
     */
    void setProcessed(int postionId);

    /**
     * 随机选取一条没有被处理过的数据
     * @return processed字段为0的数据
     */
    LagouPositionInfo findNotProcessed();
}
