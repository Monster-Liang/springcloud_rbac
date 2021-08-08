package com.rbac.rbacService.interceptor;

import org.apache.tomcat.util.net.AbstractEndpoint;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 梁家宝
 * @description 检查登录拦截器
 */
public class CheckLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //methodHandler
        //判断session使用有user对象
        if(UserContext.getCurrent() == null){  //没有登录
            log.info(handler);
            response.sendRedirect("/login.html");
            return false;
        }
        return true;
    }
}
