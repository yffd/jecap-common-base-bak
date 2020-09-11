package com.yffd.jecap.common.base.dao.mybatis;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yffd.jecap.common.base.dao.IBaseDao;
import com.yffd.jecap.common.base.entity.IBaseEntity;
import com.yffd.jecap.common.base.page.PageData;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public abstract class MybatisBaseDao<E extends IBaseEntity> implements IBaseDao<E> {

    protected abstract BaseMapper<E> getMapper();

    protected abstract Wrapper<E> getEntityWrapper(E entity);

    @Override
    public int addOne(E entity) {
        if (null == entity) return 0;
        this.beforeInsert(entity);
        return this.getMapper().insert(entity);
    }

    @Override
    public int updateById(E entity) {
        if (null == entity) return 0;
        this.beforeUpdate(entity);
        return this.getMapper().updateById(entity);
    }

    @Override
    public int update(E oldEntity, E newEntity) {
        if (null == oldEntity || null == newEntity) return 0;
        Wrapper<E> queryWrapper = this.getEntityWrapper(oldEntity);
        if (queryWrapper.isEmptyOfWhere()) return 0;
        this.beforeUpdate(newEntity);
        return this.getMapper().update(newEntity, queryWrapper);
    }

    @Override
    public int deleteById(Serializable id) {
        if (null == id) return 0;
        this.beforeDelete(id);
        return this.getMapper().deleteById(id);
    }

    @Override
    public int deleteByIds(Set<? extends Serializable> ids) {
        if (null == ids || ids.isEmpty()) return 0;
        this.beforeDelete(ids);
        return this.getMapper().deleteBatchIds(ids);
    }

    @Override
    public int delete(E entity) {
        Wrapper<E> queryWrapper = this.getEntityWrapper(entity);
        if (queryWrapper.isEmptyOfWhere()) return 0;
        this.beforeDelete(entity);
        return this.getMapper().delete(queryWrapper);
    }

    @Override
    public boolean exist(E entity) {
        return null != this.findOne(entity);
    }

    @Override
    public E findById(Serializable id) {
        if (null == id) return null;
        this.beforeSelect(id);
        return this.getMapper().selectById(id);
    }

    @Override
    public List<E> findByIds(Set<? extends Serializable> ids) {
        if (null == ids) return null;
        this.beforeSelect(ids);
        return this.getMapper().selectBatchIds(ids);
    }

    @Override
    public E findOne(E entity) {
        Wrapper<E> queryWrapper = this.getEntityWrapper(entity);
        if (queryWrapper.isEmptyOfWhere()) return null;
        this.beforeSelect(entity);
        return this.getMapper().selectOne(queryWrapper);
    }

    @Override
    public List<E> findList(E entity) {
        Wrapper<E> queryWrapper = this.getEntityWrapper(entity);
        if (queryWrapper.isEmptyOfWhere()) return null;
        this.beforeSelect(entity);
        return this.getMapper().selectList(queryWrapper);
    }

    @Override
    public List<E> findAll() {
        this.beforeSelect(null);
        return this.getMapper().selectList(null);
    }

    @Override
    public PageData<E> findPage(E entity, int pageNum, int pageSize) {
        this.beforeSelect(entity);
        Page page = this.getMapper().selectPage(new Page(pageNum, pageSize), this.getEntityWrapper(entity));
        return new PageData(
                Long.valueOf(page.getCurrent()).intValue(),
                Long.valueOf(page.getSize()).intValue(),
                Long.valueOf(page.getTotal()).intValue(), page.getRecords()
        );
    }

}
