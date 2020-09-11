package com.yffd.jecap.common.base.result;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RtnResult<T> extends BaseResult<T> {
    private static final long serialVersionUID = -4261018493651581477L;

    /** 返回编号：成功=20000=OK、失败=40000=FAIL */
    public static final String RTN_OK_CODE = "20000";
    public static final String RTN_OK_MSG = "OK";
    public static final String RTN_FAIL_CODE = "40000";
    public static final String RTN_FAIL_MSG = "FAIL";

    public static final String RTN_PARAM_ERROR_CODE = "40100";
    public static final String RTN_PARAM_ERROR_MSG = "参数错误";
    public static final String RTN_PARAM_ISNULL_CODE = "40101";
    public static final String RTN_PARAM_ISNULL_MSG = "参数不能为空";

    public static final String RTN_LOGIN_ERROR_CODE = "40300";
    public static final String RTN_LOGIN_ERROR_MSG = "登录错误";

    public static final String RTN_DATA_ERROR_CODE = "40500";
    public static final String RTN_DATA_ERROR_MSG = "数据错误";
    public static final String RTN_DATA_ADD_CODE = "40501";
    public static final String RTN_DATA_ADD_MSG = "数据添加失败";
    public static final String RTN_DATA_UPDATE_CODE = "40502";
    public static final String RTN_DATA_UPDATE_MSG = "数据修改失败";
    public static final String RTN_DATA_DEL_CODE = "40503";
    public static final String RTN_DATA_DEL_MSG = "数据删除失败";

    public RtnResult(String code, String msg, T data) {
        super(code, msg, data);
    }

    public static RtnResult OK() {
        return new RtnResult(RTN_OK_CODE, RTN_OK_MSG, null);
    }

    public static RtnResult OK(Object data) {
        return new RtnResult(RTN_OK_CODE, RTN_OK_MSG, data);
    }

    public static RtnResult OK(String code, Object data) {
        return new RtnResult(code, RTN_OK_MSG, data);
    }

    public static RtnResult FAIL() {
        return new RtnResult(RTN_FAIL_CODE, RTN_FAIL_MSG, null);
    }

    public static RtnResult FAIL(String msg) {
        return new RtnResult(RTN_FAIL_CODE, msg, null);
    }

    public static RtnResult FAIL(String code, String msg) {
        return new RtnResult(code, msg, null);
    }

    public static RtnResult FAIL_PARAM_ISNULL() {
        return new RtnResult(RTN_PARAM_ISNULL_CODE, RTN_PARAM_ISNULL_MSG, null);
    }

    public static RtnResult FAIL_ADD() {
        return new RtnResult(RTN_DATA_ADD_CODE, RTN_DATA_ADD_MSG, null);
    }

    public static RtnResult FAIL_UPDATE() {
        return new RtnResult(RTN_DATA_UPDATE_CODE, RTN_DATA_UPDATE_MSG, null);
    }

    public static RtnResult FAIL_DEL() {
        return new RtnResult(RTN_DATA_DEL_CODE, RTN_DATA_DEL_MSG, null);
    }
}
