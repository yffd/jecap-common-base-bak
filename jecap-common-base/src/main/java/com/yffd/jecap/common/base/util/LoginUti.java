package com.yffd.jecap.common.base.util;

import com.yffd.jecap.common.base.login.LoginInfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Deprecated
public class LoginUti {
    public static final String LOGIN_DATA_SESSION_KEY = "_L_D_S_K";

    public static HttpSession getSession(boolean create) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession(create);
    }

    public static HttpSession getSession() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession(true);
    }

    public static LoginInfo getLoginData() {
        return (LoginInfo) getSession().getAttribute(LOGIN_DATA_SESSION_KEY);
    }

    public static void setLoginData(LoginInfo loginData) {
        getSession().setAttribute(LOGIN_DATA_SESSION_KEY, loginData);
    }

    /** 登录账号名称 */
    public static String getLoginName() {
        return getLoginData().getLoginName();
    }
}
