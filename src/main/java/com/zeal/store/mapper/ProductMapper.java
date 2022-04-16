package com.zeal.store.mapper;

import com.zeal.store.entity.Product;

import java.util.List;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/16 12:07
 */
public interface ProductMapper {

    /**
     * 查询热销商品前四位
     * @return 商品列表
     */
    List<Product> findHotProducts();

    /**
     * 根据id查找商品
     * @param id id
     * @return 商品
     */
    Product findById(Integer id);

}
