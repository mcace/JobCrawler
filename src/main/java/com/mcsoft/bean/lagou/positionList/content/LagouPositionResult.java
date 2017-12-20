package com.mcsoft.bean.lagou.positionList.content;

import com.mcsoft.bean.lagou.positionList.content.positionResult.LagouLocationInfo;
import com.mcsoft.bean.lagou.positionList.content.positionResult.LagouPositionInfo;
import com.mcsoft.bean.lagou.positionList.content.positionResult.LagouQueryAnalysisInfo;
import com.mcsoft.bean.lagou.positionList.content.positionResult.LagouStrategyProperty;

/**
 * 拉勾网Ajax请求响应JSON中positionResult对应实体类
 * Created by Mc on 2017/12/8.
 */
public class LagouPositionResult {
    private int totalCount;
    private int resultSize;
    private LagouLocationInfo locationInfo;
    private LagouQueryAnalysisInfo queryAnalysisInfo;
    private LagouStrategyProperty strategyProperty;
    private String[] hotLabels;
    private LagouPositionInfo[] result;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getResultSize() {
        return resultSize;
    }

    public void setResultSize(int resultSize) {
        this.resultSize = resultSize;
    }

    public LagouLocationInfo getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(LagouLocationInfo locationInfo) {
        this.locationInfo = locationInfo;
    }

    public LagouQueryAnalysisInfo getQueryAnalysisInfo() {
        return queryAnalysisInfo;
    }

    public void setQueryAnalysisInfo(LagouQueryAnalysisInfo queryAnalysisInfo) {
        this.queryAnalysisInfo = queryAnalysisInfo;
    }

    public LagouStrategyProperty getStrategyProperty() {
        return strategyProperty;
    }

    public void setStrategyProperty(LagouStrategyProperty strategyProperty) {
        this.strategyProperty = strategyProperty;
    }

    public String[] getHotLabels() {
        return hotLabels;
    }

    public void setHotLabels(String[] hotLabels) {
        this.hotLabels = hotLabels;
    }

    public LagouPositionInfo[] getResult() {
        return result;
    }

    public void setResult(LagouPositionInfo[] result) {
        this.result = result;
    }
}
