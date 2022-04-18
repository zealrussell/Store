package com.zeal.store.controller;

import com.zeal.store.entity.Product;
import com.zeal.store.service.IProductService;
import com.zeal.store.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/16 12:31
 */
@RestController
@RequestMapping("products")
public class ProductController extends BaseController{

    @Autowired
    private IProductService productService;

    @RequestMapping("hot_list")
    public JSONResult<List<Product>> getHotList() {
        List<Product> data = productService.findHotList();
        return new JSONResult<List<Product>>(OK, data);
    }

    @GetMapping("{id}/details")
    public JSONResult<Product> getById(@PathVariable("id") Integer id) {
        // 调用业务对象执行获取数据
        Product data = productService.findById(id);
        // 返回成功和数据
        return new JSONResult<>(OK, data);
    }

}
