package com.yffd.jecap.common.base.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginSessionHolder {
    public static final String LOGIN_INFIO_SESSION_KEY = "_LISK";

    public static HttpSession getSession(boolean create) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (null == requestAttributes) {
            log.warn("=======非登录方式访问：获取对象【HttpSession】=======");
            return null;
        }
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        return request.getSession(create);
    }

    public static HttpSession getSession() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (null == requestAttributes) {
            log.warn("=======非登录方式访问：获取对象【HttpSession】=======");
            return null;
        }
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        return request.getSession(true);
    }

    public static LoginInfo getLoginInfo() {
        HttpSession session = getSession();
        if (null == session) {
            log.warn("=======非登录方式访问：获取对象【LoginInfo】=======");
            return null;
        }
        return (LoginInfo) session.getAttribute(LOGIN_INFIO_SESSION_KEY);
    }

    public static void setLoginInfo(LoginInfo loginInfo) {
        HttpSession session = getSession();
        if (null == session) {
            log.warn("=======非登录方式访问：设置对象【LoginInfo】=======");
            return;
        }
        session.setAttribute(LOGIN_INFIO_SESSION_KEY, loginInfo);
    }

}
