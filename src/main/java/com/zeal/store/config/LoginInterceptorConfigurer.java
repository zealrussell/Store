package com.zeal.store.config;

import com.zeal.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/9 16:06
 */
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        HandlerInterceptor interceptor = new LoginInterceptor();
        // 配置白名单

        List<String> whiteList = new ArrayList<String>();
        whiteList.add("/bootstrap3/**");
        whiteList.add("/css/**");
        whiteList.add("/js/**");
        whiteList.add("/images/**");
        whiteList.add("/web/register.html");
        whiteList.add("/web/login.html");
        whiteList.add("/web/index.html");
        whiteList.add("/web/product.html");
        whiteList.add("/products/**");
        whiteList.add("/users/**");


        // 注册拦截器
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(whiteList);

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
