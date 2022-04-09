package com.zeal.store.service.impl;

import com.zeal.store.entity.User;
import com.zeal.store.mapper.UserMapper;
import com.zeal.store.service.IUserService;
import com.zeal.store.service.ex.*;
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
    public User login(String username, String password) {

        User result = userMapper.findByUsername(username);
        //用户不存在 或 被删除
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户数据不存在");
        }

        String sault = result.getSalt();
        String newPassword = getMD5Password(password, sault);
        if(!newPassword.equals(result.getPassword())) {
            throw new PasswordNotMatchException("用户密码不正确");
        }

        //压缩返回的数据大小
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());

        return user;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户不存在");
        }
        String oldMD5 = getMD5Password(oldPassword, result.getSalt());
        if (! result.getPassword().equals(oldMD5)) {
            throw new PasswordNotMatchException("用户密码不正确");
        }
        String newMD5 = getMD5Password(newPassword, result.getSalt());
        Integer rows = userMapper.updatePasswordByUid(uid,newMD5, username, new Date());
        if (rows != 1) {
            throw new UpdateException("更新数据时产生未知异常");
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
