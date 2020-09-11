package com.yffd.jecap.common.base.exception;

public class LoginException extends BaseException {
    private static final long serialVersionUID = 7864509117750046608L;

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public static LoginException cast() {
        return new LoginException("登录错误", null);
    }

    public static LoginException cast(String message) {
        return new LoginException(message, null);
    }

    public static LoginException cast(Throwable cause) {
        return new LoginException(null, cause);
    }

    public static LoginException cast(Throwable cause, String message) {
        return new LoginException(message, cause);
    }
}
