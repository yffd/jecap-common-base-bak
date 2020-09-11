package com.yffd.jecap.admin.domain.sys.user.entity;

import com.yffd.jecap.common.base.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SysUser extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户性别，男：M、女：F、未知：U
     */
    private String userGender;

    /**
     * 用户电话
     */
    private String userPhone;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户类型，s=系统、h=医院
     */
    private String userType;

    /**
     * 用户状态，1=启用、0=禁用
     */
    private String userStatus;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 登录名称
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String loginPwd;

    /**
     * 登录密码盐
     */
    private String loginPwdSalt;

    /**
     * 登录密码修改次数
     *
     */
    private Integer loginPwdModifyTimes;

    /**
     * 登录最后时间
     */
    private String loginLastTime;

}
