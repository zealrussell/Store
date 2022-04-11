package com.zeal.store.service;

import com.zeal.store.entity.Address;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/11 18:15
 */
public interface IAddressService {
    /**
     * 添加地址
     * @param uid ud
     * @param username 用户名
     * @param address 地址
     */
    void addNewAddress(Integer uid, String username, Address address);
}
