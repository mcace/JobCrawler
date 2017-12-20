package com.mcsoft.bean.lagou.positionList;

import com.mcsoft.bean.lagou.positionList.content.LagouHrInfo;
import com.mcsoft.bean.lagou.positionList.content.LagouPositionResult;

import java.util.Map;

/**
 * 拉勾网Ajax请求响应JSON中content对应实体类
 * Created by Mc on 2017/12/8.
 */
public class LagouContent {
    private int pageNo;
    private int pageSize;
    private Map<String, LagouHrInfo> hrInfoMap;
    private LagouPositionResult positionResult;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, LagouHrInfo> getHrInfoMap() {
        return hrInfoMap;
    }

    public void setHrInfoMap(Map<String, LagouHrInfo> hrInfoMap) {
        this.hrInfoMap = hrInfoMap;
    }

    public LagouPositionResult getPositionResult() {
        return positionResult;
    }

    public void setPositionResult(LagouPositionResult positionResult) {
        this.positionResult = positionResult;
    }
}
