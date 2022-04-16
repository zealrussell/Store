package com.zeal.store.mapper;

import com.zeal.store.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/16 10:50
 */
@SpringBootTest
class AddressMapperTest {

    @Autowired
    private AddressMapper addressMapper;
    @Test
    void deleteByAid() {
        Integer integer = addressMapper.deleteByAid(3);
        if (integer == 1) System.out.println("OK");
        else System.out.println("error");
    }

    @Test
    void findLastModified() {
        Address address = addressMapper.findLastModified(5);
        System.out.println(address);
    }
}