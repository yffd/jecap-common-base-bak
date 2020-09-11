package com.yffd.jecap.common.base.page;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
 * 分页范围对象
 * @param <T>
 */
@Data
public class PageData<T> implements IBasePage, Serializable {
    private static final long serialVersionUID = 4465182140785991069L;
    //已知数据
    /** 当前页 */
    private Integer pageNum;
    /** 每页显示的数据条数 */
    private Integer pageSize;
    /** 总的记录条数 */
    private Integer totalRecord;
    /** 当前页数据列表 */
    private List<T> records;

    //需要计算得来
    /** 总页数 */
    private Integer totalPage;
    /** 开始行号 */
    private Integer startRowNum;
    /** 结束行号 */
    private Integer endRowNum;

    /** 分页显示的页数，比如在页面上显示1，2，3，4，5页，startNum就为1，endNum就为5，这个也是算过来的 */
    private Integer startPageNum;
    private Integer endPageNum;

    //通过pageNum，pageSize，totalRecord计算
    public PageData(int pageNum, int pageSize, int totalRecord) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.totalPage = this.pages();
        this.startRowNum = (pageNum - 1) * pageSize;
        this.endRowNum = pageNum * pageSize;

        //显示5页，这里自己可以设置，想显示几页就自己通过下面算法修改
        this.startPageNum = 1;
        this.endPageNum = 5;
        //显示页数的算法
        if(totalPage <= 5) {
            //总页数都小于5，那么endNum就为总页数的值
            this.endPageNum = this.totalPage;
        } else {
            //总页数大于5，根据当前是第几页，来判断startNum和endNum为多少
            this.startPageNum = pageNum - 2;
            this.endPageNum = pageNum + 2;

            if(startPageNum < 0){
                //比如当前页是第1页，或者第2页，那么就不如和这个规则，
                this.startPageNum = 1;
                this.endPageNum = 5;
            }
            if(endPageNum > this.totalPage){
                //比如当前页是倒数第2页或者最后一页，也同样不符合上面这个规则
                this.endPageNum = totalPage;
                this.startPageNum = endPageNum - 5;
            }
        }
    }

    public PageData(int pageNum, int pageSize, int totalRecord, List<T> records) {
        this(pageNum, pageSize, totalRecord);
        this.records = records;
    }

    /**
     * PageData 的泛型转换
     * @param mapper 转换函数
     * @param <R>    转换后的泛型
     * @return 转换泛型后的 PageData
     */
    public <R> PageData<R> convert(Function<? super T, ? extends R> mapper) {
        List<R> collect = this.getRecords().stream().map(mapper).collect(toList());
        ((PageData<R>) this).setRecords(collect);
        return (PageData<R>) this;
    }
}
