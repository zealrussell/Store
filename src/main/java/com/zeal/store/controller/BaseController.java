package com.zeal.store.controller;

import com.zeal.store.service.ex.*;
import com.zeal.store.util.JSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/8 16:20
 */
public class BaseController {

    public static final int OK = 200;


    // 项目产生异常时会被统一拦截到该方法中，
    // 返回json数据给前端
    //
    @ExceptionHandler(ServiceException.class)
    public JSONResult<Void> handlerException (Throwable e) {
        JSONResult<Void> result = new JSONResult<>(e);

        if (e instanceof UsernameDuplicatedException) {
            result.setState(4000);
            result.setMessage("用户名已被占用");
        } else if (e instanceof UserNotFoundException) {
            result.setState(4001);
            result.setMessage("用户数据不存在");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(4002);
            result.setMessage("用户名密码错误");
        } else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("注册时产生异常");
        }
        
        return result;
    }

    protected final Integer getuidFromSession (HttpSession session) {
       return Integer.valueOf(session.getAttribute("uid").toString());
    }

    protected final String getUsernameFromSession (HttpSession session) {
        return session.getAttribute("username").toString();
    }

}
