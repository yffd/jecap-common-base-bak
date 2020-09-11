package com.yffd.jecap.admin.domain.constant;

public class AdminConsts {

    /** 角色-超级管理员 */
    public static final String ROLE_SUPER_ADMIN = "superadmin";
    /** 默认密码 */
    public static final String DEF_LOGIN_PWD = "12345678";
    /** 树根节点ID */
    public static String DEF_TREE_ROOT_ID = "root";

    /** 删除标记，1=已逻辑删除、0=未逻辑删除 */
    public static final String DEL_FLAG_FALSE = "0";
    /** 删除标记，1=已逻辑删除、0=未逻辑删除 */
    public static final String DEL_FLAG_TRUE = "1";

    /** 启用/禁用 */
    public static final String DEF_DISABLED = "0";
    /** 启用/禁用 */
    public static final String DEF_ENABLED = "1";

    /** 用户类型-系统用户 */
    public static final String USER_TYPE_SYS = "s";
    /** 用户类型-游客 */
    public static final String USER_TYPE_VISITOR = "v";
    /** 用户类型-商铺医院 */
    public static final String USER_TYPE_HOSPTITAL = "h";
    /** 用户类型-商铺宠物店 */
    public static final String USER_TYPE_PET = "p";
}
