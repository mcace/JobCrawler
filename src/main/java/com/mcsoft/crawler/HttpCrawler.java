package com.mcsoft.crawler;

import com.mcsoft.utils.PageLoader;

import java.util.Map;

/**
 * HTTP请求爬虫
 * 会将HTTP请求响应内容完整爬下来
 * Created by Mc on 2017/12/8.
 */
public class HttpCrawler extends AbstractCrawler<String> {
    public HttpCrawler(String method, String body, Map<String, String> headers) {
        super(method, body, headers);
    }

    @Override
    public String craw(String url) {
        return PageLoader.loadPage(url, method, headers, body);
    }
}
