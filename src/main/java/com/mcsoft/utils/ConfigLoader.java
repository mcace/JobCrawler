package com.mcsoft.utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置读取工具
 * Created by Mc on 2017/12/7.
 */
public class ConfigLoader {
    private static final String HEADERS_DOC = "headers";
    private static final String RULES_DOC = "craw-rules";
    private static final String LAGOU_AJAX_HEADERS = HEADERS_DOC + File.separator +
            "lagou-ajax-headers.properties";
    private static final String LAGOU_HTML_HEADERS = HEADERS_DOC + File.separator +
            "lagou-html-headers.properties";
    private static final String LAGOU_POSITION_DETAIL_RULES = RULES_DOC + File.separator +
            "lagou-position-detail.properties";

    /**
     * 获取拉勾网Ajax请求头相关文件内容
     *
     * @return kv格式的请求头列表
     */
    public static Map<String, String> loadLagouAjaxHeaders() {
        return loadConfig(LAGOU_AJAX_HEADERS);
    }

    /**
     * 获取拉勾网HTML页面请求头相关文件内容
     *
     * @return kv格式的请求头列表
     */
    public static Map<String, String> loadLagouHtmlHeaders() {
        return loadConfig(LAGOU_HTML_HEADERS);
    }

    /**
     * 获取拉勾网职位详情页面爬虫抓取规则列表
     *
     * @return kv格式的规则列表
     */
    public static Map<String, String> loadLagouPositionDetailRules() {
        return loadConfig(LAGOU_POSITION_DETAIL_RULES);
    }

    public static Map<String, String> loadConfig(String fileName) {
        Map<String, String> configMap = new HashMap<>();
        if (null == fileName || fileName.equals("")) {
            return configMap;
        }
        String classpath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        File file = new File(classpath + File.separator + fileName);
        if (!file.exists()) {
            return configMap;
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) {
                    continue;
                }
                int splitLine = line.indexOf("=");
                if (-1 == splitLine) {
                    continue;
                }
                configMap.put(line.substring(0, splitLine), line.substring(splitLine + 1, line.length()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return configMap;
    }
}
