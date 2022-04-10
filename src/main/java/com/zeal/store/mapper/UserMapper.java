package com.zeal.store.mapper;

import com.zeal.store.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/8 9:49
 */
@Mapper
public interface UserMapper {
    /**
     * 插入用户的数据
     * @param user 用户
     * @return 受影响的行数（增删改）
     */
    Integer insert(User user);

    /**
     * 根据用户名查找用户
     * @param userName 用户名
     * @return 找到返回用户，没找到返回null
     */
    User findByUsername(String userName);

    /**
     * 根据id查找用户
     * @param uid 用户id
     * @return 成功返回user，失败返回null
     */
    User findByUid(Integer uid);

    /**
     * 根据uid 修改密码
     * @param uid id
     * @param password 密码
     * @param modifiedUser 修改者
     * @param modifiedTime 修改时间
     * @return 影响行数
     */
    Integer updatePasswordByUid(Integer uid, String password, String modifiedUser, Date modifiedTime);

    /**
     * 根据uid修改用户信息
     * @param user 用户
     * @return 行数
     */
    Integer updateInfoByUid(User user);


}
