package com.yffd.jecap.common.base.query;

import com.yffd.jecap.common.base.page.PageData;
import com.yffd.jecap.common.base.result.RtnResult;

import java.util.List;

public interface IBaseQueryService<T, C> {

    List<T> queryList(C condition);

    List<T> queryAll();

    PageData<T> queryRange(C condition, int pageNum, int pageSize);

    RtnResult<T> queryPage(C condition, int pageNum, int pageSize);

}
