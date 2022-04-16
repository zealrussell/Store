package com.zeal.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/9 15:09
 */
public class LoginInterceptor implements HandlerInterceptor {

    // 拦截未登录
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object uid = request.getSession().getAttribute("uid");
        if (uid == null) {
            System.out.println("拦截" + request.getRequestURI());
            response.sendRedirect("/web/login.html");
            return false;
        }
        return true;
    }

    // 在ModleAndView对象关联的资源被执行完毕之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    // 整个请求所有关联的资源被执行完毕最后执行的方法
    // 一般用于资源回收
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
