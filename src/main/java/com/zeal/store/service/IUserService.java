package com.zeal.store.service;

import com.zeal.store.entity.User;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/8 15:18
 */
public interface IUserService {
    /**
     * 用户注册方法
     * @param user 用户的数据对象
     */
    void reg(User user);

    /**
     * md5加密操作
     * @param password 密码
     * @param sault 颜值
     * @return md5密码
     */
    String getMD5Password(String password, String sault);


}
