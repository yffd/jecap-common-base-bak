package com.yffd.jecap.common.base.exception;

public abstract class BaseException extends RuntimeException {
    private static final long serialVersionUID = 3370827708316971779L;
    private String msg;

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public <E extends BaseException> E prompt() {
        this.msg = null == this.getMessage() ? this.getMsg() : this.getMessage();
        return (E) this;
    }

    public <E extends BaseException> E prompt(String msg) {
        this.msg = null == this.getMessage() ? this.getMsg() : msg;
        return (E) this;
    }

    public String getMsg() {
        return "未知错误";
    }

/*
    public static BaseException cast() {
        return new BaseException();
    }

    public static BaseException cast(String message) {
        return new BaseException(message, null);
    }

    public static BaseException cast(Throwable cause) {
        return new BaseException(null, cause);
    }

    public static BaseException cast(Throwable cause, String message) {
        return new BaseException(message, cause);
    }
*/

}
