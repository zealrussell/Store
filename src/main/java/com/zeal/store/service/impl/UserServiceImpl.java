package com.zeal.store.service.impl;

import com.zeal.store.entity.User;
import com.zeal.store.mapper.UserMapper;
import com.zeal.store.service.IUserService;
import com.zeal.store.service.ex.InsertException;
import com.zeal.store.service.ex.UsernameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/8 15:21
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        User result = userMapper.findByUsername(user.getUsername());
        if (result != null) {
            throw new UsernameDuplicatedException("用户名被占用");
        }

        //进行MD5加密
        String sault = UUID.randomUUID().toString().toUpperCase();
        String md5password = getMD5Password(user.getPassword(),sault);
        user.setPassword(md5password);
        user.setSalt(sault);

        //填写默认字段
        Date date = new Date();
        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setCreatedTime(date);
        user.setModifiedUser(user.getUsername());
        user.setModifiedTime(date);

        Integer rows = userMapper.insert(user);
        if (rows != 1) {
            throw new InsertException("用户注册发生异常");
        }
    }

    @Override
    public String getMD5Password(String password, String sault) {
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((sault + password + sault).getBytes()).toUpperCase();
        }
        return password;
    }
}
