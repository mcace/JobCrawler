package com.mcsoft.crawler;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬虫抽象类
 * Created by Mc on 2017/12/8.
 */
public abstract class AbstractCrawler<T> implements Crawler {
    protected String method;
    protected String body;
    protected Map<String, String> headers;

    public AbstractCrawler(String method, String body, Map<String, String> headers) {
        if (null == method || "".equals(method)) method = "GET";
        this.method = method;
        this.body = body;
        this.headers = headers;
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
}
