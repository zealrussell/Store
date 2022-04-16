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
            result.setMessage("用户名已被占用异常");
        } else if (e instanceof UserNotFoundException) {
            result.setState(4001);
            result.setMessage("用户数据不存在异常");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(4002);
            result.setMessage("用户名密码错误异常");
        } else if (e instanceof AddressCountLimitException) {
            result.setState(4003);
            result.setMessage("用户地址超出上限异常");
        } else if (e instanceof AddressNotFoundException) {
            result.setState(4004);
            result.setMessage("用户收货地址数据不存在异常");
        } else if (e instanceof AccessDeniedException) {
            result.setState(4005);
            result.setMessage("用户收货地址非法访问的异常");
        } else if (e instanceof ProductNotFoundException) {
            result.setState(4006);
            result.setMessage("商品数据不存在异常");
        } else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("注册时产生异常");
        } else if (e instanceof UpdateException) {
            result.setState(5001);
            result.setMessage("更新数据时产生异常");
        } else if (e instanceof DeleteException){
            result.setState(5002);
            result.setMessage("删除地址时产生异常");
        } else if (e instanceof FileEmptyException) {
            result.setState(6000);
            result.setMessage("上传文件为空异常");
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
            result.setMessage("上传文件超出大小异常");
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
            result.setMessage("上传文件类型异常");
        } else if (e instanceof FileStateException) {
            result.setState(6003);
            result.setMessage("上传文件状态异常");
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
            result.setMessage("上传文件读写异常");
        }

        return result;
    }

    protected final Integer getUidFromSession (HttpSession session) {
       return Integer.valueOf(session.getAttribute("uid").toString());
    }

    protected final String getUsernameFromSession (HttpSession session) {
        return session.getAttribute("username").toString();
    }

}
