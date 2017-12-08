package com.mcsoft.utils;

/**
 * 常量类
 * Created by Mc on 2017/12/8.
 */
public class Constants {
    //拉勾网查询连接
    public static String LAGOU_AJAX_URL = "https://www.lagou.com/jobs/positionAjax.json";

    /**
     * 返回拉勾网完整查询连接
     *
     * @param urlParams URL参数
     * @return 完整查询连接
     */
    public static String getLagouAjaxUrl(String urlParams) {
        return LAGOU_AJAX_URL + "?" + urlParams;
    }
}
