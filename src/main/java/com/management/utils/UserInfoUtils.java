package com.management.utils;

import com.management.entity.UserBean;

public class UserInfoUtils {
    private static final ThreadLocal<UserBean> USERINFO = new ThreadLocal<>();

    /**
     * 获取用户
     * @return
     */
    public static UserBean getUser() {
        return USERINFO.get();
    }

    /**
     * 获取用户id
     * @return
     */
    public static Integer getUserId() {
        return getUser().getId();
    }

    /**
     * 存储用户信息
     * @param user 用户对象
     */
    public static void setUser(UserBean user) {
        USERINFO.set(user);
    }

    /**
     * 删除用户信息
     */
    public static void remove() {
        USERINFO.remove();
    }

    /**
     * 获取用户UUID
     * @return
     */
    public static String getUserUUID() {
        return getUser().getUuid();
    }
}
