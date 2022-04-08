package com.zeal.store.controller;

import com.zeal.store.entity.User;
import com.zeal.store.service.IUserService;
import com.zeal.store.service.ex.InsertException;
import com.zeal.store.service.ex.UsernameDuplicatedException;
import com.zeal.store.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
