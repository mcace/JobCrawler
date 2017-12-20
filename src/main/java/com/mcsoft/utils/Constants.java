package com.mcsoft.utils;

import java.util.HashMap;

/**
 * 常量类
 * 可以构造URL
 * Created by Mc on 2017/12/8.
 */
public class Constants {
    //拉勾网查询链接
    public static String LAGOU_AJAX_URL = "https://www.lagou.com/jobs/positionAjax.json";
    //不同数据类型的默认值设置，用于在处理实体类时设置默认值
    public static HashMap<Class, Object> DEFAULT_VALUES_MAP = new HashMap<>();
    public static String METHOD_POST = "POST";
    //拉勾网职位详情页面链接
    public static String LAGOU_POSITION_URL = "https://www.lagou.com/jobs/[job_id].html";
    //拉勾网职位面试评价JSON链接
    public static String LAGOU_POSITION_INTERVIEW_EXP_URL = "https://www.lagou" +
            ".com/interview/experience/byPosition.positionList";

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

    /**
     * 获取职位详情页面链接
     *
     * @param positionId 职位id
     * @return 职位详情页面URL
     */
    public static String getPositionUrl(String positionId) {
        return LAGOU_POSITION_URL.replace("[job_id]", positionId);
    }
}
