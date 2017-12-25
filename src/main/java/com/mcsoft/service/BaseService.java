package com.mcsoft.service;

import java.io.Serializable;

/**
 * 基础Service接口
 * Created by Mc on 2017/12/25.
 */
public interface BaseService<T> {

    /**
     * 保存或更新对象
     *
     * @param obj 待保存或更新的对象
     */
    void saveOrUpdate(T obj);

    /**
     * 保存对象
     *
     * @param obj 待保存的对象
     * @return 如果更新成功，返回id，如果失败返回null
     */
    Serializable save(T obj);

    /**
     * 更新对象
     *
     * @param obj 待更新对象
     * @return 更新成功则返回对象id，否则返回null
     */
    Serializable update(T obj);

    /**
     * id查找
     *
     * @param clazz 待查找对象class
     * @param id    待查找对象id
     * @return 查到的对象
     */
    T findById(Class<T> clazz, Serializable id);

    /**
     * id删除
     *
     * @param clazz 待删除对象class
     * @param id    待删除对象id
     */
    void deleteById(Class<T> clazz, Serializable id);

    /**
     * 批量保存或更改，必须开启事务
     *
     * @param objs 批量保存的数据
     */
    void batchSaveOrUpdate(T[] objs);
}
