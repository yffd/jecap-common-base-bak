package com.yffd.jecap.common.base.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public abstract class BaseEntity implements IBaseEntity, Serializable {
    protected String id;            //主键
    protected Integer version;      //版本号
    protected String delFlag = "0"; //删除标记，已删除=1、未删除=0
    protected String createBy;      //创建者
    protected Date createTime;      //创建时间
    protected String updateBy;      //修改者
    protected Date updateTime;      //修改时间

}
