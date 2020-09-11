package com.yffd.jecap.common.base.login;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class LoginInfo implements Serializable {
    private static final long serialVersionUID = -5989520636536630645L;
    /** 登录账号名称 */
    private String loginName;

    /** 用户ID */
    private String userId;
    /** 用户名称 */
    private String userName;
    /** 用户类型 */
    private String userType;

    /** 超级管理员 */
    private boolean isSuperAdmin = false;
    /** 当前登录人拥有的角色 */
    private Set<String> roles;


}
