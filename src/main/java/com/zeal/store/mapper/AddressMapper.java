package com.zeal.store.mapper;

import com.zeal.store.entity.Address;

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
     * @param uid
     * @return
     */
    Integer countByUid(Integer uid);
}
