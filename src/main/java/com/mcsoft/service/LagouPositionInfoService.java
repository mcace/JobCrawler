package com.mcsoft.service;

import com.mcsoft.bean.lagou.positionList.content.positionResult.LagouPositionInfo;

/**
 * 拉钩职位信息service层
 * Created by Mc on 2017/12/15.
 */
public interface LagouPositionInfoService {
    /**
     * 查找一条未被处理的数据
     *
     * @return 未被处理的职位信息数据
     */
    LagouPositionInfo findOneUnprocessed();

    /**
     * 将数据置为已处理
     *
     * @param id 数据id
     */
    void setProcessed(int id);

    void saveOrUpdate(LagouPositionInfo obj);

    void batchSaveOrUpdate(LagouPositionInfo[] objs);
}
