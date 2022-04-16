package com.zeal.store.service.impl;

import com.zeal.store.entity.Address;
import com.zeal.store.mapper.AddressMapper;
import com.zeal.store.service.IAddressService;
import com.zeal.store.service.IDistrictService;
import com.zeal.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
    @Autowired
    private IDistrictService districtService;
    @Value("${user.address.max-count}")
    private int maxCount;

    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        Integer count = addressMapper.countByUid(uid);
        if ( count > maxCount ) {
            throw new AddressCountLimitException("收货地址数量达到上限");
        }
        // 补全省市区信息
        String ProvinceName = districtService.getNameByCode(address.getProvinceCode());
        String AreaName = districtService.getNameByCode(address.getAreaCode());
        String CityName = districtService.getNameByCode(address.getCityCode());
        address.setAreaName(AreaName);
        address.setProvinceName(ProvinceName);
        address.setCityName(CityName);

        // 补全地址信息
        address.setUid(uid);
        Integer isDefault = count == 0 ? 1 : 0;
        address.setIsDefault(isDefault);
        Date date = new Date();
        address.setCreatedUser(username);
        address.setCreatedTime(date);
        address.setModifiedUser(username);
        address.setModifiedTime(date);

        //插入地址
        Integer rows = addressMapper.insert(address);
        if (rows != 1) {
            throw new InsertException("插入收货地址数据时出现未知错误，请联系系统管理员！");
        }

    }

    @Override
    public List<Address> getByUid(Integer uid) {
        List<Address> list = addressMapper.findByUid(uid);
        for (Address address : list) {
            address.setUid(null);
            address.setProvinceCode(null);
            address.setCityCode(null);
            address.setAreaCode(null);
            address.setCreatedUser(null);
            address.setCreatedTime(null);
            address.setModifiedUser(null);
            address.setModifiedTime(null);
        }
        return list;
    }

    @Transactional
    @Override
    public void setDefault(Integer aid, Integer uid, String username) {
        Address result = addressMapper.findByAid(aid);
        if (result == null) {
            throw new AddressNotFoundException("收获地址不存在");
        }
        if (!result.getUid().equals(uid)) {
            throw new AccessDeniedException("非法访问");
        }
        Integer rows = addressMapper.updateNonDefaultByUid(uid);
        if (rows < 1) {
            throw new UpdateException("更新数据时产生未知异常");
        }
        rows = addressMapper.updateDefaultByAid(aid, username, new Date());
        if (rows != 1) {
            throw new UpdateException("更新数据是产生未知异常");
        }


    }

    @Transactional
    @Override
    public void delete(Integer aid, Integer uid, String username) {
        Address result = addressMapper.findByAid(aid);
        if (result == null) {
            throw new AddressNotFoundException("收获地址不存在");
        }
        if (!result.getUid().equals(uid)) {
            throw new AccessDeniedException("非法访问");
        }
        Integer rows = addressMapper.deleteByAid(aid);
        if (rows != 1) {
            throw new DeleteException("删除地址数据出现错误");
        }
        if (result.getIsDefault() == 0) {
            return;
        }

        // 如果删除的不是默认地址，还需设置默认地址
        Integer count = addressMapper.countByUid(uid);
        if (count == 0) {
            return;
        }
        Address lastModified = addressMapper.findLastModified(uid);
        Integer lastModifiedAid = lastModified.getAid();
        Integer rows2 = addressMapper.updateDefaultByAid(lastModifiedAid, username, new Date());
        if (rows2 != 1) {
            throw new UpdateException("更新收货地址数据时出现未知错误，请联系系统管理员");
        }

    }


}
