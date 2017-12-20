package com.mcsoft.crawler.handler.impl;

import com.mcsoft.crawler.handler.CrawHandler;

/**
 * HTML数据默认处理器
 * Created by Mc on 2017/12/20.
 */
public class DefaultHtmlHandler implements CrawHandler<String> {
    @Override
    public String handle(String content) {
        return content;
    }
}
