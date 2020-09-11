package com.yffd.jecap.common.base.exception;

public class SysException extends BaseException {
    private static final long serialVersionUID = -5074890056414516568L;

    public SysException(String message, Throwable cause) {
        super(message, cause);
    }

    public static SysException cast() {
        return new SysException("系统错误", null);
    }

    public static SysException cast(String message) {
        return new SysException(message, null);
    }

    public static SysException cast(Throwable cause) {
        return new SysException(null, cause);
    }

    public static SysException cast(Throwable cause, String message) {
        return new SysException(message, cause);
    }
}
