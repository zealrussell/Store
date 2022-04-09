package com.zeal.store.controller;

import com.zeal.store.entity.User;
import com.zeal.store.service.IUserService;
import com.zeal.store.service.ex.InsertException;
import com.zeal.store.service.ex.UsernameDuplicatedException;
import com.zeal.store.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/8 16:07
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;

    // 注册时可能产生的异常，被拦截到BaseController处理
    @RequestMapping("reg")
    public JSONResult<Void> reg(User user) {
        userService.reg(user);
        return new JSONResult<>(OK);
    }

    @RequestMapping("login")
    public JSONResult<User> login(String username, String password, HttpSession session){
        User user = userService.login(username, password);
        session.setAttribute("uid",user.getUid());
        session.setAttribute("username",user.getUsername());
        return new JSONResult<User>(OK,user);
    }

    @RequestMapping("change_password")
    public JSONResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session) {
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid, username, oldPassword, newPassword);
        return new JSONResult<>(OK);

    }

}
