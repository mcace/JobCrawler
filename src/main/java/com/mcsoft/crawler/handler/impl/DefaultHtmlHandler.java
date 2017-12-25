package com.mcsoft.crawler.handler.impl;

import com.mcsoft.crawler.handler.DataHandler;
import com.mcsoft.exception.HandleException;

/**
 * HTML数据默认处理器
 * Created by Mc on 2017/12/20.
 */
public class DefaultHtmlHandler implements DataHandler<String> {
    @Override
    public String handle(String content) throws HandleException {
        if (null == content || "".equals(content))
            throw new HandleException("数据为空");
        return content;
    }
}
