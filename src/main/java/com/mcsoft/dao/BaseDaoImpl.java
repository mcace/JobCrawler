package com.mcsoft.dao;

import com.mcsoft.bean.DBModel;
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
        if (src_obj == null || src_obj.equals(obj)) {
            return null;
        }
        BeanUtils.copyNotNullField(obj, src_obj);
        session.update(src_obj);
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
        for (T obj : objs) {
            this.getCurrentSession().saveOrUpdate(obj);
        }
    }
}
