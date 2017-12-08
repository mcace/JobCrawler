package com.mcsoft.crawler;

import com.alibaba.fastjson.JSON;
import com.mcsoft.utils.PageLoader;

import java.util.Map;

/**
 * JSON数据爬虫
 * 根据爬出的JSON数据转为对应的实体类
 * Created by Mc on 2017/12/8.
 */
public class JsonCrawler<T> extends AbstractCrawler {
    private Class<T> clazz;//JSON转实体类对应CLASS

    public JsonCrawler(String method, String body, Map<String, String> headers, Class<T> clazz) {
        super(method, body, headers);
        this.clazz = clazz;
    }

    public T craw(String url) {
        String json = PageLoader.loadPage(url, method, headers, body);
        return JSON.parseObject(json, clazz);
    }
}
