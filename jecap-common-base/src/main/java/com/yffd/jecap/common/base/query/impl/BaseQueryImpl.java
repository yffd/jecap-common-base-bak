package com.yffd.jecap.common.base.query.impl;

import com.yffd.jecap.common.base.entity.IBaseEntity;
import com.yffd.jecap.common.base.page.PageData;
import com.yffd.jecap.common.base.repository.IBaseRepo;
import com.yffd.jecap.common.base.result.RtnResult;
import com.yffd.jecap.common.base.query.IBaseQueryService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public abstract class BaseQueryImpl<E extends IBaseEntity> implements IBaseQueryService<E, E> {

    protected abstract IBaseRepo getRepo();

    @Override
    public List<E> queryList(E condition) {
        return this.getRepo().getList(condition);
    }

    @Override
    public List<E> queryAll() {
        return this.getRepo().getAll();
    }

    @Override
    public PageData<E> queryRange(E condition, int pageNum, int pageSize) {
        return this.getRepo().getPage(condition, pageNum, pageSize);
    }

    @Override
    public RtnResult<E> queryPage(E condition, int pageNum, int pageSize) {
        RtnResult<E> pageData = this.queryPage(condition, pageNum, pageSize);
        return RtnResult.OK(pageData);
    }

}
