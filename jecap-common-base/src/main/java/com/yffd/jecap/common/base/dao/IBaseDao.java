package com.yffd.jecap.common.base.dao;

import com.yffd.jecap.common.base.entity.IBaseEntity;
import com.yffd.jecap.common.base.page.PageData;
import com.yffd.jecap.common.base.util.EntityUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface IBaseDao<E extends IBaseEntity> {

    int addOne(E entity);

    int updateById(E entity);

    int update(E oldEntity, E newEntity);

    int deleteById(Serializable id);

    int deleteByIds(Set<? extends Serializable> ids);

    int delete(E entity);

    boolean exist(E entity);

    E findById(Serializable id);

    List<E> findByIds(Set<? extends Serializable> ids);

    E findOne(E entity);

    List<E> findList(E entity);

    List<E> findAll();

    PageData<E> findPage(E entity, int pageNum, int pageSize);

    default void beforeInsert(Object obj) {
        if (null == obj) return;
        EntityUtil.initPropsForAdd(obj);
    }

    default void beforeUpdate(Object obj) {
        if (null == obj) return;
        EntityUtil.initPropsForUpdate(obj);
    }

    default void beforeSelect(Object obj) {
        if (null == obj) return;
        EntityUtil.initPropsForQuery(obj);
    }

    default void beforeDelete(Object obj) {
//        if (null == obj) return;
//        EntityUtil.initPropsForDelete(obj);
    }

}
