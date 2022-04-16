package com.zeal.store.mapper;

import com.zeal.store.entity.Address;

import java.util.Date;
import java.util.List;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/11 17:42
 */
public interface AddressMapper {
    /**
     * 插入用户的收货地址
     * @param address 地址
     * @return 行数
     */
    Integer insert(Address address);

    /**
     * 根据用户的id查询收货地址数量
     * @param uid id
     * @return 数量
     */
    Integer countByUid(Integer uid);

    /**
     * 查询某用户的收货地址列表数据
     * @param uid 收货地址归属的用户id
     * @return 该用户的收货地址列表数据
     */
    List<Address> findByUid(Integer uid);

    /**
     * 根据aid查询地址
     * @param aid aid
     * @return 地址
     */
    Address findByAid(Integer aid);

    /**
     * 将某用户的所有收货地址设置为非默认地址
     * @param uid 收货地址归属的用户id
     * @return 受影响的行数
     */
    Integer updateNonDefaultByUid(Integer uid);

    /**
     * 根据aid修改默认地址
     * @param aid
     * @return 行数
     */
    Integer updateDefaultByAid(Integer aid, String modifiedUser, Date modifiedTime);

    /**
     * 根据地址aid删除
     * @param aid aid
     * @return 行数
     */
    Integer deleteByAid(Integer aid);

    /**
     * 查询某用户最后修改的收货地址
     * @param uid 归属的用户id
     * @return 该用户最后修改的收货地址，如果该用户没有收货地址数据则返回null
     */
    Address findLastModified(Integer uid);


}
