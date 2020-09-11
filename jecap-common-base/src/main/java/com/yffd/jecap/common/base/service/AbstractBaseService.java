package com.yffd.jecap.common.base.service;

import com.yffd.jecap.common.base.entity.IBaseEntity;
import com.yffd.jecap.common.base.page.PageData;
import com.yffd.jecap.common.base.repository.IBaseRepo;
import com.yffd.jecap.common.base.result.RtnResult;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Transactional
public abstract class AbstractBaseService<E extends IBaseEntity> implements IBaseService<E> {

    protected abstract IBaseRepo getRepo();

    @Override
    public int add(E entity) {
        if (null == entity) return 0;
        return this.getRepo().save(entity);
    }

    @Override
    public int addBatch(List<E> entityList) {
        if (CollectionUtils.isEmpty(entityList)) return 0;
        int tmp = 0;
        for (E entity : entityList) {
            tmp += this.add(entity);
        }
        return tmp;
    }

    @Override
    public int updateById(E entity) {
        if (null == entity) return 0;
        return this.getRepo().updateById(entity);
    }

    @Override
    public int updateBy(E oldEntity, E newEntity) {
        if (null == oldEntity || null == newEntity) return 0;
        return this.getRepo().update(oldEntity, newEntity);
    }

    @Override
    public int deleteById(Serializable id) {
        if (null == id) return 0;
        return this.getRepo().removeById(id);
    }

    @Override
    public int deleteByIds(Set<Serializable> ids) {
        if (null == ids || ids.isEmpty()) return 0;
        return this.getRepo().removeByIds(ids);
    }

    @Override
    public int deleteBy(E entity) {
        if (null == entity) return 0;
        return this.getRepo().remove(entity);
    }

    @Override
    public boolean existById(Serializable id) {
        return null != this.getById(id);
    }

    @Override
    public boolean exist(E entity) {
        return null != this.getBy(entity);
    }

    @Override
    public E getById(Serializable id) {
        return (E) this.getRepo().getById(id);
    }

    @Override
    public List<E> getByIds(Set<? extends Serializable> ids) {
        return this.getRepo().getByIds(ids);
    }

    @Override
    public E getBy(E entity) {
        return (E) this.getRepo().get(entity);
    }

    @Override
    public List<E> getList(E entity) {
        return this.getRepo().getList(entity);
    }

    @Override
    public List<E> getAll() {
        return this.getRepo().getAll();
    }

    @Override
    public PageData<E> getRange(E entity, int pageNum, int pageSize) {
        return this.getRepo().getPage(entity, pageNum, pageSize);
    }

    @Override
    public RtnResult<E> getPage(E entity, int pageNum, int pageSize) {
        PageData<E> pageData = this.getRange(entity, pageNum, pageSize);
        return RtnResult.OK(pageData);
    }
}
