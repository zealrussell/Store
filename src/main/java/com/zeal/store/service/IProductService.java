package com.zeal.store.service;

import com.zeal.store.entity.Product;

import java.util.List;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/16 12:22
 */
public interface IProductService {

    /**
     * 查询热销商品的前四名
     * @return 热销商品前四名的集合
     */
    List<Product> findHotList();

    /**
     * 根据id找商品
     * @param id id
     * @return 商品
     */
    Product findById(Integer id);
}
