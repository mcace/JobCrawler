package com.mcsoft.bean.lagou.params;

import com.mcsoft.utils.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 拉勾网Url参数
 * Created by Mc on 2017/12/8.
 */
public class LagouURLParam {
    private String px = "default";//排序
    private YX yx = YX.NoLimit;//月薪
    private String city = "上海";//工作地点
    private String needAddtionalResult = "false";//不明
    private String isSchoolJob = "0";//是否是校招


    public LagouURLParam() {
    }

    public LagouURLParam(String px, YX yx, String city, String needAddtionalResult, String
            isSchoolJob) {
        if (!StringUtils.isEmpty(px)) this.px = px;
        if (null != yx) this.yx = yx;
        if (!StringUtils.isEmpty(city)) this.city = city;
        if (!StringUtils.isEmpty(needAddtionalResult)) this.needAddtionalResult = needAddtionalResult;
        if (!StringUtils.isEmpty(isSchoolJob)) this.isSchoolJob = isSchoolJob;
    }

    /**
     * 将参数转为URL参数并返回
     *
     * @return URL参数
     */
    public String toUrlParams() {
        StringBuilder builder = new StringBuilder();
        try {
            if (!StringUtils.isEmpty(px)) {
                builder.append("px=");
                builder.append(URLEncoder.encode(px, "utf8"));
                builder.append("&");
            }
            if (!YX.NoLimit.equals(yx)) {
                builder.append("yx=");
                builder.append(URLEncoder.encode(yx.toString(), "utf8"));
                builder.append("&");
            }
            if (!StringUtils.isEmpty(city)) {
                builder.append("city=");
                builder.append(URLEncoder.encode(city, "utf8"));
                builder.append("&");
            }
            if (!StringUtils.isEmpty(needAddtionalResult)) {
                builder.append("needAddtionalResult=");
                builder.append(URLEncoder.encode(needAddtionalResult, "utf8"));
                builder.append("&");
            }
            if (!StringUtils.isEmpty(isSchoolJob)) {
                builder.append("isSchoolJob=");
                builder.append(URLEncoder.encode(isSchoolJob, "utf8"));
                builder.append("&");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String result = builder.toString();
        if (result.endsWith("&")) result = result.substring(0, result.length() - 1);
        return result;
    }

    /**
     * 返回默认参数
     *
     * @return 默认参数
     */
    public static String defaultURLParams() {
        return new LagouURLParam().toUrlParams();
    }

    public String getPx() {
        return px;
    }

    public void setPx(String px) {
        this.px = px;
    }

    public YX getYx() {
        return yx;
    }

    public void setYx(YX yx) {
        this.yx = yx;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeedAddtionalResult() {
        return needAddtionalResult;
    }

    public void setNeedAddtionalResult(String needAddtionalResult) {
        this.needAddtionalResult = needAddtionalResult;
    }

    public String getIsSchoolJob() {
        return isSchoolJob;
    }

    public void setIsSchoolJob(String isSchoolJob) {
        this.isSchoolJob = isSchoolJob;
    }

    /**
     * 月薪选项
     */
    public enum YX {
        NoLimit("不限"), LOWER_THAN_2K("2k以下"), TwoK_FiveK("2k-5k"), FiveK_TenK("5k-10k"),
        TenK_FifteenK("10k-15k"), Fifteen_TwentyFive("15k-25k"), TwentyFive_Fifty("25k-50k"),
        FiftyAndMore("50k以上");

        private String name;

        YX(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }

    }
}
