package com.mcsoft.bean;

import java.io.Serializable;

/**
 * 通用数据库模型
 * Created by Mc on 2017/12/14.
 */
public interface DBModel {
    /**
     * 获取实体类的ID值
     *
     * @return 实体类ID
     */
    Serializable getId();

    /**
     * 对比两个数据库对象是否值相等
     *
     * @param target 对比的对象
     * @return 如果对象相等则为true，不相等则为false
     */
    boolean equals(Object target);
}
