package com.zeal.store.controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.zeal.store.entity.Address;
import com.zeal.store.service.IAddressService;
import com.zeal.store.service.IDistrictService;
import com.zeal.store.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

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
        return new JSONResult<Void>(OK);
    }

    @GetMapping({"", "/"})
    public JSONResult<List<Address>> getByUid(HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<Address> data = addressService.getByUid(uid);
        return new JSONResult<>(OK, data);
    }

    @RequestMapping("{aid}/set_default")
    public JSONResult<Void> setDefault(@PathVariable("aid") Integer aid, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.setDefault(aid, uid, username);
        return new JSONResult<Void>(OK);
    }

    @RequestMapping("{aid}/delete")
    public JSONResult<Void> delete(@PathVariable("aid") Integer aid, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.delete(aid, uid, username);
        return new JSONResult<>(OK);
    }

}