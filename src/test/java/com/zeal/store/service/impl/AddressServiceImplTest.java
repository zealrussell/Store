package com.zeal.store.service.impl;

import com.zeal.store.entity.Address;
import com.zeal.store.service.IAddressService;
import com.zeal.store.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/11 19:44
 */
@SpringBootTest
class AddressServiceImplTest {

    @Autowired
    private IAddressService addressService;

    @Test
    void addNewAddress() {
        try {
            Integer uid = 5;
            String username = "admin";
            Address address = new Address();
            address.setName("李四");
            address.setPhone("12345678911");
            address.setAddress("南京市玄武区");
            addressService.addNewAddress(uid, username, address);
            System.out.println("OK.");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    void updateDefault(){
        addressService.setDefault(2,2,"zeal");

    }
}