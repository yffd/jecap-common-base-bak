package com.yffd.jecap.common.base.repository;

import com.yffd.jecap.common.base.dao.IBaseDao;
import com.yffd.jecap.common.base.entity.IBaseEntity;
import com.yffd.jecap.common.base.page.PageData;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public abstract class AbstractBaseRepo<E extends IBaseEntity> {

    protected abstract IBaseDao<E> getDao();

    public int save(E entity) {
        if (null == entity) return 0;
        return this.getDao().addOne(entity);
    }

    public int update(E oldEntity, E newEntity) {
        if (null == oldEntity || null == newEntity) return 0;
        return this.getDao().update(oldEntity, newEntity);
    }

    public int updateById(E entity) {
        if (null == entity) return 0;
        return this.getDao().updateById(entity);
    }

    public int remove(E entity) {
        if (null == entity) return 0;
        return this.getDao().delete(entity);
    }

    public int removeById(Serializable id) {
        if (null == id) return 0;
        return this.getDao().deleteById(id);
    }

    public int removeByIds(Set<? extends Serializable> ids) {
        if (null == ids || ids.size() == 0) return 0;
        return this.getDao().deleteByIds(ids);
    }

    public E get(E entity) {
        if (null == entity) return null;
        return this.getDao().findOne(entity);
    }

    public E getById(Serializable id) {
        if (null == id) return null;
        return this.getDao().findById(id);
    }

    public List<E> getByIds(Set<? extends Serializable> ids) {
        if (null == ids || ids.size() == 0) return Collections.emptyList();
        return this.getDao().findByIds(ids);
    }

    public List<E> getList(E entity) {
        if (null == entity) return Collections.emptyList();
        return this.getDao().findList(entity);
    }

    public List<E> getAll() {
        return this.getDao().findAll();
    }

    public PageData<E> getPage(E entity, int pageNum, int pageSize) {
        return this.getDao().findPage(entity, pageNum, pageSize);
    }
}
