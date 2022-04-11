package com.zeal.store.service.impl;

import com.zeal.store.entity.Address;
import com.zeal.store.mapper.AddressMapper;
import com.zeal.store.service.IAddressService;
import com.zeal.store.service.ex.AddressCountLimitException;
import com.zeal.store.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/11 19:31
 */

@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Value("${user.address.max-count}")
    private int maxCount;

    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        Integer count = addressMapper.countByUid(uid);
        if ( count > maxCount ) {
            throw new AddressCountLimitException("收货地址数量达到上限");
        }
        address.setUid(uid);
        Integer isDefault = count == 0 ? 1 : 0;
        address.setIsDefault(isDefault);
        Date date = new Date();
        address.setCreatedUser(username);
        address.setCreatedTime(date);
        address.setModifiedUser(username);
        address.setModifiedTime(date);
        Integer rows = addressMapper.insert(address);
        if (rows != 1) {
            throw new InsertException("插入收货地址数据时出现未知错误，请联系系统管理员！");
        }
    }
}
