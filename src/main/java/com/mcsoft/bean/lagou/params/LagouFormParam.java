package com.mcsoft.bean.lagou.params;

/**
 * 拉勾网Ajax提交表单参数
 * Created by Mc on 2017/12/8.
 */
public class LagouFormParam {
    private String pn = "1";//页码
    private String kd = "Java";//搜索关键字
    private String first = "true";//不明

    public LagouFormParam() {
    }

    public LagouFormParam(String pn, String kd, String first) {
        this.pn = pn;
        this.kd = kd;
        this.first = first;
    }

    /**
     * 返回表单参数，并将页码加一
     *
     * @param limit 页面最大值
     * @return 表单参数
     */
    public String toParamAndIncreasePN(int limit) {
        String params = this.toFormParam();
        int pn = Integer.valueOf(this.pn);
        if (pn < limit) this.pn = String.valueOf(++pn);
        return params;
    }

    /**
     * 返回默认参数
     *
     * @return 默认参数
     */
    public static String defaultFormParams() {
        return new LagouFormParam().toFormParam();
    }

    /**
     * 将参数转为表单参数并返回
     *
     * @return 表单参数
     */
    public String toFormParam() {
        return "pn=" + pn + "&kd=" + kd + "&first=" + first;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getKd() {
        return kd;
    }

    public void setKd(String kd) {
        this.kd = kd;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }
}
