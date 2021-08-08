package com.rbac.rbacService.config;

import com.rbac.rbacService.interceptor.CheckLoginInterceptor;
import com.rbac.rbacService.interceptor.CheckPerssionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * @author  梁家宝
 * @description 拦截器配置
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private CheckLoginInterceptor checkLoginInterceptor;
    @Autowired
    private CheckPerssionInterceptor checkPermissionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //注册拦截器
        registry.addInterceptor(checkLoginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login.html", "/login", "/static/**");  // 对那些url不进行拦截

        //配置权限访问控制的拦截器
        registry.addInterceptor(checkPermissionInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login.html", "/login", "/static/**");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //进行资源映射,  把url与本地路径对应

        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
