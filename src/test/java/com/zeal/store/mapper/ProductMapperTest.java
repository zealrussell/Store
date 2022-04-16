package com.zeal.store.mapper;

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
 * @date 2022/4/16 12:16
 */
@SpringBootTest
class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;
    @Test
    void findHotProducts() {
        List<Product> list = productMapper.findHotProducts();
        list.forEach(System.out::println);
    }

}