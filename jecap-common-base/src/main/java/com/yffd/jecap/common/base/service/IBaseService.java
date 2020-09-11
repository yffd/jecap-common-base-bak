package com.yffd.jecap.common.base.service;

import com.yffd.jecap.common.base.entity.IBaseEntity;
import com.yffd.jecap.common.base.page.PageData;
import com.yffd.jecap.common.base.result.RtnResult;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface IBaseService<E extends IBaseEntity> {

    /** 添加 */
    int add(E entity);
    /** 添加-批量 */
    int addBatch(List<E> entityList);

    /** 修改 */
    int updateById(E entity);
    /** 修改 */
    int updateBy(E oldEntity, E newEntity);

    /** 删除 */
    int deleteById(Serializable id);
    /** 删除-批量 */
    int deleteByIds(Set<Serializable> ids);
    /** 删除 */
    int deleteBy(E entity);

    /** 存在 */
    boolean existById(Serializable id);
    /** 存在 */
    boolean exist(E entity);

    /** 获取-单个 */
    E getById(Serializable id);
    /** 获取-单个 */
    List<E> getByIds(Set<? extends Serializable> ids);
    /** 获取-单个 */
    E getBy(E entity);
    /** 获取-列表 */
    List<E> getList(E entity);
    /** 获取-列表 */
    List<E> getAll();
    /** 获取-范围 */
    PageData<E> getRange(E entity, int pageNum, int pageSize);
    /** 获取-分页 */
    RtnResult<E> getPage(E entity, int pageNum, int pageSize);

}
