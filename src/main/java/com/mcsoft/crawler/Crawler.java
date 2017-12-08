package com.mcsoft.crawler;

/**
 * 爬虫接口
 * Created by Mc on 2017/12/7.
 */
public interface Crawler<T> {
    /**
     * 爬取操作
     * @param url 爬取url
     * @return 爬取出的数据
     */
    T craw(String url);
}
