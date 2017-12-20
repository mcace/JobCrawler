package com.mcsoft.crawler;

import com.mcsoft.crawler.handler.impl.DefaultHtmlHandler;

import java.util.Map;

/**
 * HTTP请求爬虫
 * 会将HTTP请求响应内容完整爬下来
 * Created by Mc on 2017/12/8.
 */
public class HtmlCrawler extends AbstractCrawler<String> {

    public HtmlCrawler(Map<String, String> headers) {
        super("GET", null, headers, new DefaultHtmlHandler());
    }
}
