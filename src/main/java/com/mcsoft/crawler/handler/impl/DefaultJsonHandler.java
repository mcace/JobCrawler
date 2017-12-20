package com.mcsoft.crawler.handler.impl;

import com.alibaba.fastjson.JSON;
import com.mcsoft.crawler.handler.CrawHandler;

/**
 * JSON数据默认处理器
 * Created by Mc on 2017/12/20.
 */
public class DefaultJsonHandler<T> implements CrawHandler<T> {
    private Class<T> clazz;//JSON转实体类对应CLASS

    public DefaultJsonHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T handle(String content) {
        if ("".equals(content))
            return null;
        return JSON.parseObject(content, clazz);
    }
}
