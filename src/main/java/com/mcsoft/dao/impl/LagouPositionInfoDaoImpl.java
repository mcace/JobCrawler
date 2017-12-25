package com.mcsoft.dao.impl;

import com.mcsoft.bean.lagou.positionList.content.positionResult.LagouPositionInfo;
import com.mcsoft.dao.LagouPositionInfoDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * 拉钩职位信息DAO
 * Created by Mc on 2017/12/14.
 */
@Repository
public class LagouPositionInfoDaoImpl extends BaseDaoImpl<LagouPositionInfo> implements
        LagouPositionInfoDao {

    @Override
    public LagouPositionInfo findById(Serializable id) {
        return super.findById(LagouPositionInfo.class, id);
    }

    @Override
    public void deleteById(Serializable id) {
        super.deleteById(LagouPositionInfo.class, id);
    }

    @Override
    public void setProcessed(int postionId) {
        LagouPositionInfo info = this.findById(LagouPositionInfo.class, postionId);
        if (null != info && new Integer(0).equals(info.getProcessed())) {
            info.setProcessed(1);
            this.update(info);
        }
    }

    @Override
    public LagouPositionInfo findNotProcessed() {
        Session session = this.getCurrentSession();
        Criteria criteria = session.createCriteria(LagouPositionInfo.class);
        criteria.add(Restrictions.eq("processed",0));
        criteria.setMaxResults(1);
        List positionInfoList = criteria.list();
        if(0 != positionInfoList.size()){
            return (LagouPositionInfo) positionInfoList.get(0);
        }
        return null;
    }
}
