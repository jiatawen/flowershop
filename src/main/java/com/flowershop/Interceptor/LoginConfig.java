package com.flowershop.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration registration = registry.addInterceptor(new UserLoginInterceptor());
//        //所有路径拦截
//        registration.addPathPatterns("/**");
//        //白名单
//        registration.excludePathPatterns("/login", "static/**", "/user/index.html","/user/login.html","/user/register.html");
    }
}
