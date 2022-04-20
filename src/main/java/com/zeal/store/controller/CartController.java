package com.zeal.store.controller;

import com.zeal.store.service.ICartService;
import com.zeal.store.util.JSONResult;
import com.zeal.store.vo.CartVO;
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
 * @date 2022/4/18 10:04
 */
@RestController
@RequestMapping("carts")
public class CartController extends BaseController{
    @Autowired
    private ICartService cartService;

    @RequestMapping("add_to_cart")
    public JSONResult<Void> addToCart(Integer pid, Integer amount, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        cartService.addToCart(uid, pid, amount, username);
        return new JSONResult<>(OK);
    }

    @RequestMapping({"","/"})
    public JSONResult<List<CartVO>> getVOByUid(HttpSession session) {
        List<CartVO> voList = cartService.getVOByUid(getUidFromSession(session));
        return new JSONResult<>(OK,voList);
    }

    @RequestMapping("{cid}/num/add")
    public JSONResult<Integer> addNum(@PathVariable("cid") Integer cid, HttpSession session) {
        // 从Session中获取uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行增加数量
        Integer data = cartService.addNum(cid, uid, username);
        // 返回成功
        return new JSONResult<Integer>(OK, data);
    }

    @RequestMapping("{cid}/num/del")
    public JSONResult<Integer> delNum(@PathVariable("cid") Integer cid, HttpSession session) {
        // 从Session中获取uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行增加数量
        Integer data = cartService.delNum(cid, uid, username);
        // 返回成功
        return new JSONResult<Integer>(OK, data);
    }

    @RequestMapping("{cid}/del")
    public JSONResult<Void> delProduct(@PathVariable("cid") Integer cid, HttpSession session) {
        // 从Session中获取uid和username
        Integer uid = getUidFromSession(session);
        cartService.delCart(cid, uid);
        // 返回成功
        return new JSONResult<Void>(OK);
    }

    @GetMapping("list")
    public JSONResult<List<CartVO>> getVOByCids(Integer[] cids, HttpSession session) {
        // 从Session中获取uid
        Integer uid = getUidFromSession(session);
        // 调用业务对象执行查询数据
        List<CartVO> data = cartService.getVOByCids(uid, cids);
        // 返回成功与数据
        return new JSONResult<>(OK, data);
    }

}
