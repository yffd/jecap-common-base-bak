package com.yffd.jecap.common.base.page;

/**
 * 分页接口
 */
public interface IBasePage {
    /** 当前页 */
    Integer getPageNum();
    /** 每页显示的数据条数 */
    Integer getPageSize();
    /** 总的记录条数 */
    Integer getTotalRecord();

    /**
     * 计算总页数
     * @return
     */
    default int pages() {
        if (getPageSize() == 0) return 0;
        int pages = getTotalRecord() / getPageSize();
        if (getTotalRecord() % getPageSize() != 0) pages++;
        return pages;
    }

    /**
     * 计算当前分页偏移量<br/>
     * 用于limit的第一个变量值
     * @return
     */
    default int offset() {
        return getPageNum() > 0 ? (getPageNum() - 1) * getPageSize() : 0;
    }

    /**
     * 是否存在上一页
     * @return
     */
    default boolean hasPrevious() {
        return getPageNum() > 1;
    }

    /**
     * 是否存在下一页
     * @return
     */
    default boolean hasNext() {
        return getPageNum() < this.pages();
    }

    /**
     * 是否为第一页
     * @return
     */
    default boolean isFirst() {
        return (getPageNum() == 1) || (getTotalRecord() == 0);
    }

    /**
     * 是否为最后一页
     * @return
     */
    default boolean isLast() {
        return (getTotalRecord() == 0) || (getPageNum() >= pages());
    }

    /**
     * 下一页的页码号
     * @return
     */
    default int getNextPage() {
        if (getPageNum() >= pages()) return pages();
        return getPageNum() + 1;
    }

    /**
     * 上一页的页码号
     * @return
     */
    default int getPrevPage() {
        if (getPageNum() <= 1) return 1;
        return getPageNum() - 1;
    }

}
