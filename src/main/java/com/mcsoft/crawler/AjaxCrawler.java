package com.mcsoft.crawler;

import com.mcsoft.crawler.handler.impl.DefaultJsonHandler;

import java.util.Map;

/**
 * Ajax请求爬虫
 * Created by Mc on 2017/12/8.
 */
public class AjaxCrawler<T> extends AbstractCrawler<T> {
    public AjaxCrawler(Class<T> clazz) {
        this(null, clazz);
    }

    public AjaxCrawler(Map<String, String> headers, Class<T> clazz) {
        this(null, headers, clazz);
    }

    public AjaxCrawler(String body, Map<String, String> headers, Class<T> clazz) {
        super("POST", body, headers, new DefaultJsonHandler<>(clazz));
    }
}
