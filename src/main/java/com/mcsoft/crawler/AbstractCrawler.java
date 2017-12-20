package com.mcsoft.crawler;

import com.mcsoft.crawler.handler.DataHandler;
import com.mcsoft.utils.PageLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬虫抽象类
 * Created by Mc on 2017/12/8.
 */
public abstract class AbstractCrawler<T> implements Crawler {
    private String method;
    private String body;
    private Map<String, String> headers;
    private DataHandler<T> handler;

    public AbstractCrawler(String method, String body, Map<String, String> headers, DataHandler<T>
            handler) {
        if (null == method || "".equals(method)) method = "GET";
        this.method = method;
        this.body = body;
        this.headers = headers;
        this.handler = handler;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setHeader(String name, String value) {
        this.headers.put(name, value);
    }

    public void removeHeader(String name) {
        this.headers.remove(name);
    }

    public void removeAllHeaders() {
        this.headers = new HashMap<>();
    }

    @Override
    public T craw(String url) {
        if (null == url || "".equals(url)) {
            return null;
        }
        String content = PageLoader.loadPage(url, method, headers, body);
        return handler.handle(content);
    }
}
