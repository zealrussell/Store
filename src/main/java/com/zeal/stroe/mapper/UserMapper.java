package com.zeal.stroe.mapper;

import com.zeal.stroe.entity.User;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/8 9:49
 */
public interface UserMapper {
    /**
     * 插入用户的数据
     * @param user
     * @return 受影响的行数（增删改）
     */
    Integer insert(User user);

    /**
     * 根据用户名查找用户
     * @param userName
     * @return 找到返回用户，没找到返回null
     */
    User findByUsername(String userName);

    /**
     *
     * @param uid
     * @return
     */
    User findByUid(String uid);
}
