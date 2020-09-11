package com.yffd.jecap.common.base.exception;

public class UnsupportMethodException extends BaseException {
    private static final long serialVersionUID = 2885055559668366937L;

    public UnsupportMethodException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMsg() {
        return "为支持的方法";
    }

    public static UnsupportMethodException cast() {
        return new UnsupportMethodException("为支持的方法", null);
    }

    public static UnsupportMethodException cast(String message) {
        return new UnsupportMethodException(message, null);
    }

    public static UnsupportMethodException cast(Throwable cause) {
        return new UnsupportMethodException(null, cause);
    }

    public static UnsupportMethodException cast(Throwable cause, String message) {
        return new UnsupportMethodException(message, cause);
    }
}
