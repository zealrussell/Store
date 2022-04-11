package com.zeal.store.controller;

import com.zeal.store.entity.Address;
import com.zeal.store.service.IAddressService;
import com.zeal.store.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/11 19:54
 */
@RequestMapping("addresses")
@RestController
public class AddressController extends BaseController{

    @Autowired
    private IAddressService addressService;

    @RequestMapping("add_new_address")
    public JSONResult<Void> addNewAddress (Address address, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.addNewAddress(uid, username, address);
        return new JSONResult<>(OK);
    }



}