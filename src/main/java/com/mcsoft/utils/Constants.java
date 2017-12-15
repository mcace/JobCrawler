package com.mcsoft.utils;

import java.util.HashMap;

/**
 * 常量类
 * Created by Mc on 2017/12/8.
 */
public class Constants {
    //拉勾网查询连接
    public static String LAGOU_AJAX_URL = "https://www.lagou.com/jobs/positionAjax.json";
    public static HashMap<Class, Object> DEFAULT_VALUES_MAP = new HashMap<>();
    public static String METHOD_POST = "POST";

    static {
        DEFAULT_VALUES_MAP.put(String.class, "");
        DEFAULT_VALUES_MAP.put(Boolean.class, true);
        DEFAULT_VALUES_MAP.put(Short.class, 0);
        DEFAULT_VALUES_MAP.put(Integer.class, 0);
        DEFAULT_VALUES_MAP.put(Long.class, 0L);
        DEFAULT_VALUES_MAP.put(Character.class, "");
    }

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
