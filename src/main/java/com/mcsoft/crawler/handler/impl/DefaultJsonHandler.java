package com.mcsoft.crawler.handler.impl;

import com.alibaba.fastjson.JSON;
import com.mcsoft.crawler.handler.DataHandler;
import com.mcsoft.exception.HandleException;

/**
 * JSON数据默认处理器
 * Created by Mc on 2017/12/20.
 */
public class DefaultJsonHandler<T> implements DataHandler<T> {
    private Class<T> clazz;//JSON转实体类对应CLASS

    public DefaultJsonHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T handle(String content) throws HandleException {
        if (null == content || "".equals(content))
            throw new HandleException("数据为空");
        try {
            return JSON.parseObject(content, clazz);
        } catch (Exception e) {
            throw new HandleException("fastjson处理错误，json数据：" + content, e);
        }
    }
}
