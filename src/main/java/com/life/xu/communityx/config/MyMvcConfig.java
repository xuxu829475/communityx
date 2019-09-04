package com.life.xu.communityx.config;

import com.life.xu.communityx.interceptor.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: communityx
 * @description: 配置类
 * @author: Mr.Xu
 * @create: 2019-09-04 16:29
 **/
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Autowired
    LoginHandlerInterceptor loginHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/","/css/**",
                                        "/fonts/**",
                                        "/images/**",
                                        "/js/**",
                                        "/webjars/**",
                        "/callback");
    }
}
