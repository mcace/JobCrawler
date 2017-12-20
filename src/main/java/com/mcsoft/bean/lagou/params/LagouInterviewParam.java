package com.mcsoft.bean.lagou.params;

/**
 * 拉勾网面试评价Ajax参数
 * Created by Mc on 2017/12/20.
 */
public class LagouInterviewParam {
    //职位id
    private long positionId;
    //页面大小
    private int pageSize = 500;

    public LagouInterviewParam(long positionId) {
        this.positionId = positionId;
    }

    public long getPositionId() {
        return positionId;
    }

    public void setPositionId(long positionId) {
        this.positionId = positionId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 将参数转为表单参数并返回
     *
     * @return 表单参数
     */
    public String toFormParam() {
        return "positionId=" + this.positionId + "&pageSize=" + this.pageSize;
    }

    public static String toFormParam(long positionId){
        return new LagouInterviewParam(positionId).toFormParam();
    }
}
