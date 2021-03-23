package com.management.filter;

import com.management.entity.UserBean;
import com.management.service.serviceImpl.UserServiceImpl;
import com.management.utils.UserInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SessionInterceptor implements HandlerInterceptor  {
    @Autowired
    private UserServiceImpl userService;
    /**
     * 请求执行前执行的
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("拦截器执行------");
        /**
         * 请求前设置过滤
         */
        String userName = (String)request.getSession().getAttribute("userName");
        String password =(String)request.getSession().getAttribute("password");
        UserBean userBean = userService.login(userName,password, request.getSession());
        UserInfoUtils.setUser(userBean);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        /**
         * 请求后执行
         */
        UserInfoUtils.remove();
    }
}
