package com.mcsoft.dao.impl;

import com.mcsoft.bean.DBModel;
import com.mcsoft.dao.BaseDao;
import com.mcsoft.utils.BeanUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * 基础数据库Dao类
 * Created by Mc on 2017/12/9.
 */
public class BaseDaoImpl<T extends DBModel> implements BaseDao<T> {
    @Resource
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveOrUpdate(T obj) {
        BeanUtils.setNullToDefault(obj);
        this.getCurrentSession().saveOrUpdate(obj);
    }

    @Override
    public Serializable save(T obj) {
        Session session = this.getCurrentSession();
        Object src_obj = session.get(obj.getClass(), obj.getId());
        if (src_obj == null) {
            return this.getCurrentSession().save(obj);
        }
        return null;
    }

    @Override
    public Serializable update(T obj) {
        Session session = this.getCurrentSession();
        Object src_obj = session.get(obj.getClass(), obj.getId());
        BeanUtils.setNullToDefault(obj);
        if (src_obj == null || src_obj.equals(obj)) {
            return null;
        }
        session.update(obj);
        return obj.getId();
    }

    @Override
    public T findById(Class<T> clazz, Serializable id) {
        return this.getCurrentSession().get(clazz, id);
    }

    @Override
    public void deleteById(Class<T> clazz, Serializable id) {
        T obj = this.getCurrentSession().get(clazz, id);
        if (null != obj) {
            this.getCurrentSession().delete(obj);
        }
    }

    @Override
    public void batchSaveOrUpdate(T[] objs) {
        Session session = this.getCurrentSession();
        for (T obj : objs) {
            Object entity = session.get(obj.getClass(), obj.getId());
            if (null == entity) {
                session.save(obj);
            } else {
                BeanUtils.setNullToDefault(obj);
                //由于此时事务中还未提交数据库，查出来的null字段还是null，而不是数据库中的默认值，因此要处理
                BeanUtils.setNullToDefault(entity);
                if (!obj.equals(entity)) {
                    try {
                        session.update(obj);
                    } catch (Exception e) {
                        session.merge(obj);
                    }
                }
            }
        }
    }
}
