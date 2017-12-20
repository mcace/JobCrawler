package com.mcsoft.crawler;

import com.mcsoft.crawler.handler.impl.DefaultJsonHandler;

import java.util.Map;

/**
 * Ajax请求爬虫
 * Created by Mc on 2017/12/8.
 */
public class AjaxCrawler<T> extends AbstractCrawler<T> {

    public AjaxCrawler(String method, String body, Map<String, String> headers, Class<T> clazz) {
        super(method, body, headers,new DefaultJsonHandler<>(clazz));
    }
}
