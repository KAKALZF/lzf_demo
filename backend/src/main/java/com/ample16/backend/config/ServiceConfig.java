package com.ample16.backend.config;

import com.ample16.backend.entity.AuthScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class ServiceConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthSocpeFilter());
        super.addInterceptors(registry);
    }

    /**
     * 拦截器:拦截贴有AuthScope标签的方法.校验用户是否有访问权限
     */
    private class AuthSocpeFilter extends HandlerInterceptorAdapter {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
            if (!(handler instanceof HandlerMethod)) return true;
            HandlerMethod method = (HandlerMethod) handler;
            AuthScope authScope = method.getMethod().getAnnotation(AuthScope.class);
            if (authScope == null) {
                return true;
            }
            String name = method.getBean().getClass().getName();
            System.out.println("name====" + name);
            System.out.println(authScope.value());
            return true;
        }
    }

}
