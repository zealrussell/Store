package com.zeal.store.service;

import com.zeal.store.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/16 13:01
 */
@SpringBootTest
class IProductServiceTest {

    @Autowired
    private IProductService productService;

    @Test
    void findHotList() {
        List<Product> hotList = productService.findHotList();
        hotList.forEach(System.out::println);
    }
}