package com.mcsoft.crawler.handler;

/**
 * 爬虫数据处理接口
 * Created by Mc on 2017/12/20.
 */
public interface CrawHandler<T> {
    /**
     * 接收响应体，返回处理后的数据
     * @param content 相应体
     * @return 指定类型的数据
     */
    T handle(String content);
}
