package com.management.utils;

import com.management.entity.UserBean;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Objects;

public abstract class LogInfo {
    private static final String userUuid=null;

    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public UserBean getAccount() {
        HttpSession session = getRequest().getSession();
        return (UserBean) session.getAttribute(userUuid);
    }

    public void setAccount(UserBean userBean) {
        HttpSession session = getRequest().getSession();
        if (userBean != null) {
            session.setAttribute(userUuid, userBean);
            //session过期时间设置，以秒为单位，即在没有活动30分钟后，session将失效
            session.setMaxInactiveInterval(30 * 60);
        }
    }
}
