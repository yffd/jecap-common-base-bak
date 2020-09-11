package com.yffd.jecap.common.base.web.model;

import lombok.Data;

/**
 * 分页查询条件基类
 */
@Data
public class PageModel implements IBaseModel {
    private int pageNum = 1;
    private int pageSize = 20;
    private Integer startRowNum;

    public PageModel() {
        this.startRowNum = (pageNum - 1) * pageSize;
    }

    public PageModel(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.startRowNum = (pageNum - 1) * pageSize;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
        this.startRowNum = (pageNum - 1) * pageSize;
    }
}
