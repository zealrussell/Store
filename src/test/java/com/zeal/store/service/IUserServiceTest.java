package com.zeal.store.service;

import com.zeal.store.entity.User;
import com.zeal.store.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/8 15:31
 */
@SpringBootTest
public class IUserServiceTest {

    @Autowired
    private IUserService userService;


    @Test
    void login(){
        User user = userService.login("zeal3","1234");
        System.out.println(user);
    }

    @Test
    void update(){

    }
}