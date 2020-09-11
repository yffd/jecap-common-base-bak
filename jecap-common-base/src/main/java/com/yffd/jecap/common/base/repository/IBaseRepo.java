package com.yffd.jecap.common.base.repository;

import com.yffd.jecap.common.base.entity.IBaseEntity;
import com.yffd.jecap.common.base.page.PageData;
import com.yffd.jecap.common.base.util.EntityUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface IBaseRepo<E extends IBaseEntity> {

    int save(E entity);

    int update(E oldEntity, E newEntity);

    int updateById(E entity);

    int remove(E entity);

    int removeById(Serializable id);

    int removeByIds(Set<? extends Serializable> ids);

    E get(E entity);

    E getById(Serializable id);

    List<E> getByIds(Set<? extends Serializable> ids);

    List<E> getList(E entity);

    List<E> getAll();

    PageData<E> getPage(E entity, int pageNum, int pageSize);

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
