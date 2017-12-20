package com.mcsoft.crawler;

import com.mcsoft.crawler.handler.CrawHandler;

import java.util.Map;

/**
 * 自定义爬虫
 * 按照自己实现的CrawlHandler进行处理数据
 * Created by Mc on 2017/12/8.
 */
public class CustomCrawler<T> extends AbstractCrawler<T> {

    public CustomCrawler(String method, String body, Map<String, String> headers, CrawHandler<T> handler) {
        super(method, body, headers, handler);
    }
}