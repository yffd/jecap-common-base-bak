package com.yffd.jecap.common.base.util;

import com.yffd.jecap.common.base.entity.BaseEntity;
import com.yffd.jecap.common.base.login.LoginInfo;
import com.yffd.jecap.common.base.login.LoginSessionHolder;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Map;

public class EntityUtil {

    public static void initPropsForAdd(Object pojo) {
        if(pojo instanceof BaseEntity) {
            BaseEntity entity = (BaseEntity) pojo;
            if (null == entity.getVersion()) entity.setVersion(0);
            if (StringUtils.isBlank(entity.getDelFlag())) entity.setDelFlag("0");
            if (null == entity.getCreateTime()) entity.setCreateTime(new Date());
            if (StringUtils.isBlank(entity.getCreateBy())) {
                LoginInfo loginInfo = LoginSessionHolder.getLoginInfo();
                entity.setCreateBy(null == loginInfo ? null : loginInfo.getUserName());
            }
        } else if(pojo instanceof Map) {
            Map<String, Object> parameter = (Map<String, Object>) pojo;
            if (null == parameter.get("version")) parameter.put("version", 0);
            if (null == parameter.get("delFlag")) parameter.put("delFlag", "0");
            if (null == parameter.get("createTime")) parameter.put("createTime", new Date());
            if (null == parameter.get("createBy")) {
                LoginInfo loginInfo = LoginSessionHolder.getLoginInfo();
                parameter.put("createBy", null == loginInfo ? null : loginInfo.getUserName());
            }
        }
    }

    public static void initPropsForUpdate(Object pojo) {
        if(pojo instanceof BaseEntity) {
            BaseEntity entity = (BaseEntity) pojo;
            if (null == entity.getUpdateBy()) entity.setUpdateTime(new Date());
            if (StringUtils.isBlank(entity.getUpdateBy())) {
                LoginInfo loginInfo = LoginSessionHolder.getLoginInfo();
                entity.setUpdateBy(null == loginInfo ? null : loginInfo.getUserName());
            }
        } else if(pojo instanceof Map) {
            Map<String, Object> parameter = (Map<String, Object>) pojo;
            if (null == parameter.get("updateTime")) parameter.put("updateTime", new Date());
            if (null == parameter.get("updateBy")) {
                LoginInfo loginInfo = LoginSessionHolder.getLoginInfo();
                parameter.put("updateBy", null == loginInfo ? null : loginInfo.getUserName());
            }
        }
    }

    public static void initPropsForQuery(Object pojo) {
        if(pojo instanceof BaseEntity) {
            BaseEntity entity = (BaseEntity) pojo;
            if (StringUtils.isBlank(entity.getDelFlag()))  entity.setDelFlag("0");
        } else if(pojo instanceof Map) {
            Map<String, Object> parameter = (Map<String, Object>) pojo;
            if (null == parameter.get("delFlag")) parameter.put("delFlag", "0");
        }
    }

    public static void initPropsForDelete(Object pojo) {

    }


    public static void initPropsForQuery(Object pojo, LoginInfo loginData) {
        if(pojo instanceof BaseEntity) {
            BaseEntity entity = (BaseEntity) pojo;
            if (StringUtils.isBlank(entity.getDelFlag()))  entity.setDelFlag("0");
        } else if(pojo instanceof Map) {
            Map<String, Object> parameter = (Map<String, Object>) pojo;
            if (null == parameter.get("delFlag")) parameter.put("delFlag", "0");
        }
    }

    public static void initPropsForAdd(Object pojo, LoginInfo loginData) {
        if(pojo instanceof BaseEntity) {
            BaseEntity entity = (BaseEntity) pojo;
            if (null == entity.getVersion()) entity.setVersion(0);
            if (StringUtils.isBlank(entity.getDelFlag())) entity.setDelFlag("0");
            if (null == entity.getCreateTime()) entity.setCreateTime(new Date());
            if (StringUtils.isBlank(entity.getCreateBy()) && null != loginData)
                entity.setCreateBy(loginData.getUserName());
        } else if(pojo instanceof Map) {
            Map<String, Object> parameter = (Map<String, Object>) pojo;
            if (null == parameter.get("version")) parameter.put("version", 0);
            if (null == parameter.get("delFlag")) parameter.put("delFlag", "0");
            if (null == parameter.get("createTime")) parameter.put("createTime", new Date());
            if (null == parameter.get("createBy") && null != loginData) parameter.put("createBy", loginData.getUserName());
        }
    }

    public static void initPropsForUpdate(Object pojo, LoginInfo loginData) {
        if(pojo instanceof BaseEntity) {
            BaseEntity entity = (BaseEntity) pojo;
            if (null == entity.getUpdateBy()) entity.setUpdateTime(new Date());
            if (StringUtils.isBlank(entity.getUpdateBy()) && null != loginData) entity.setUpdateBy(loginData.getUserName());
        } else if(pojo instanceof Map) {
            Map<String, Object> parameter = (Map<String, Object>) pojo;
            if (null == parameter.get("updateTime")) parameter.put("updateTime", new Date());
            if (null == parameter.get("updateBy") && null != loginData) parameter.put("updateBy", loginData.getUserName());
        }
    }

    public static void initPropsForDelete(Object pojo, LoginInfo loginData) {

    }

}
