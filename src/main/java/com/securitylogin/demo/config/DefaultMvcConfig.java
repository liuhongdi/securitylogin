package com.securitylogin.demo.config;


import com.securitylogin.demo.interceptor.WebInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import javax.servlet.Filter;

/**
 * @desc: mvc config
 * @author: liuhongdi
 * @date: 2020-07-01 11:40
 */
@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class DefaultMvcConfig implements WebMvcConfigurer {

    @Resource
    private WebInterceptor webInterceptor;

    //添加Interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //1.加入的顺序就是拦截器执行的顺序，
        //2.按顺序执行所有拦截器的preHandle
        //3.所有的preHandle 执行完再执行全部postHandle 最后是postHandle

        registry.addInterceptor(webInterceptor)
                .addPathPatterns("/home/**","/user/**","/admin/**","/merchant/**")
                .excludePathPatterns("/html/*","/js/*");
    }
}