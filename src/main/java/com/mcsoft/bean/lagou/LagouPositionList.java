package com.mcsoft.bean.lagou;

import com.mcsoft.bean.lagou.positionList.LagouContent;

/**
 * 拉勾网Ajax请求响应JSON对应实体类
 * Created by Mc on 2017/12/8.
 */
public class LagouPositionList {
    private boolean success;
    private String msg;
    private String requestId;
    private String resubmitToken;
    private LagouContent content;
    private int code;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getResubmitToken() {
        return resubmitToken;
    }

    public void setResubmitToken(String resubmitToken) {
        this.resubmitToken = resubmitToken;
    }

    public LagouContent getContent() {
        return content;
    }

    public void setContent(LagouContent content) {
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
