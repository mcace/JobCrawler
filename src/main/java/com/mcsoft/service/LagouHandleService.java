package com.mcsoft.service;

/**
 * 拉勾网数据爬取主要Service
 * Created by Mc on 2018/1/17.
 */
public interface LagouHandleService {
    /**
     * 爬取一级页面数据并保存
     */
    void firstStep();

    /**
     * 爬取二级页面数据并保存
     */
    void secondStep();
}
