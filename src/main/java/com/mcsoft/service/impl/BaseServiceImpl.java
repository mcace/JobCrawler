package com.mcsoft.service.impl;

import com.mcsoft.bean.DBModel;
import com.mcsoft.dao.BaseDao;
import com.mcsoft.service.BaseService;

import java.io.Serializable;

/**
 * 基础Service实现类
 * Created by Mc on 2017/12/25.
 */
public class BaseServiceImpl<T extends DBModel> implements BaseService<T> {
    private BaseDao<T> dao;

    public BaseServiceImpl(BaseDao<T> dao) {
        this.dao = dao;
    }

    @Override
    public void saveOrUpdate(T obj) {
        dao.saveOrUpdate(obj);
    }

    @Override
    public Serializable save(T obj) {
        return dao.save(obj);
    }

    @Override
    public Serializable update(T obj) {
        return dao.update(obj);
    }

    @Override
    public T findById(Class<T> clazz, Serializable id) {
        return dao.findById(clazz, id);
    }

    @Override
    public void deleteById(Class<T> clazz, Serializable id) {
        dao.deleteById(clazz, id);
    }

    @Override
    public void batchSaveOrUpdate(T[] objs) {
        dao.batchSaveOrUpdate(objs);
    }
}
