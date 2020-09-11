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

public interface MybatisplusBaseDao<E extends IBaseEntity> extends IBaseDao<E>, BaseMapper<E> {

    Wrapper<E> getWrapper(E entity);

    default BaseMapper<E> getMapper() {
        return this;
    }

    default int addOne(E entity) {
        if (null == entity) return 0;
        this.beforeInsert(entity);
        return this.insert(entity);
    }

    default int update(E oldEntity, E newEntity) {
        if (null == oldEntity || null == newEntity) return 0;
        Wrapper<E> queryWrapper = this.getWrapper(oldEntity);
        if (queryWrapper.isEmptyOfWhere()) return 0;
        this.beforeUpdate(newEntity);
        return this.update(newEntity, queryWrapper);
    }

    default int deleteByIds(Set<? extends Serializable> ids) {
        if (null == ids || ids.isEmpty()) return 0;
        this.beforeDelete(ids);
        return this.deleteBatchIds(ids);
    }

    default int delete(E entity) {
        Wrapper<E> queryWrapper = this.getWrapper(entity);
        if (queryWrapper.isEmptyOfWhere()) return 0;
        this.beforeDelete(entity);
        return this.delete(queryWrapper);
    }

    default boolean exist(E entity) {
        return null != this.findOne(entity);
    }

    default E findById(Serializable id) {
        if (null == id) return null;
        this.beforeSelect(id);
        return this.selectById(id);
    }

    default List<E> findByIds(Set<? extends Serializable> ids) {
        if (null == ids) return null;
        this.beforeSelect(ids);
        return this.selectBatchIds(ids);
    }

    default E findOne(E entity) {
        Wrapper<E> queryWrapper = this.getWrapper(entity);
        if (queryWrapper.isEmptyOfWhere()) return null;
        this.beforeSelect(entity);
        return this.selectOne(queryWrapper);
    }

    default List<E> findList(E entity) {
        Wrapper<E> queryWrapper = this.getWrapper(entity);
        if (queryWrapper.isEmptyOfWhere()) return null;
        this.beforeSelect(entity);
        return this.selectList(queryWrapper);
    }

    default List<E> findAll() {
        this.beforeSelect(null);
        return this.selectList(null);
    }

    default PageData<E> findPage(E entity, int pageNum, int pageSize) {
        this.beforeSelect(entity);
        Page page = this.selectPage(new Page(pageNum, pageSize), this.getWrapper(entity));
        return new PageData(
                Long.valueOf(page.getCurrent()).intValue(),
                Long.valueOf(page.getSize()).intValue(),
                Long.valueOf(page.getTotal()).intValue(), page.getRecords()
        );
    }
}
