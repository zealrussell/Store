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

    /**
     * 登录函数
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回对象，失败返回null
     */
    User login(String username, String password);

    /**
     * 修改用户密码
     * @param uid id
     * @param username 用户名
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     */
    void changePassword(Integer uid, String username, String oldPassword, String newPassword);

    /**
     * 根据uid查找用户
     * @param uid uid
     * @return 用户
     */
    User getByUid(Integer uid);

    /**
     * 修改用户信息
     * @param uid uid
     * @param username 用户名
     * @param user 用户对象数据
     */
    void changeInfo(Integer uid, String username, User user);

    /**
     * 上传头像
     * @param uid uid
     * @param avatar 头像地址
     * @param username 用户名
     */
    void changeAvatar(Integer uid, String avatar, String username);
}
