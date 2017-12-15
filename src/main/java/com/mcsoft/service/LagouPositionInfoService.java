package com.mcsoft.service;

import com.mcsoft.bean.lagou.json.content.positionResult.LagouPositionInfo;

/**
 * 拉钩职位信息service层
 * Created by Mc on 2017/12/15.
 */
public interface LagouPositionInfoService {
    void saveOrUpdate(LagouPositionInfo obj);

    void batchSaveOrUpdate(LagouPositionInfo[] objs);
}
