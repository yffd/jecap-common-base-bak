package com.yffd.jecap.admin.domain.exception;

import com.yffd.jecap.common.base.exception.BaseException;

public class AdminException extends BaseException {
    private static final long serialVersionUID = -689907954359500172L;

    public AdminException(String message, Throwable cause) {
        super(message, cause);
    }

    public static AdminException cast() {
        return new AdminException("系统错误【代号：admin】", null);
    }

    public static AdminException cast(String message) {
        return new AdminException(message, null);
    }

    public static AdminException cast(Throwable cause) {
        return new AdminException(null, cause);
    }

    public static AdminException cast(Throwable cause, String message) {
        return new AdminException(message, cause);
    }

}
