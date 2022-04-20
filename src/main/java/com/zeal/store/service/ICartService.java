package com.zeal.store.service;

import com.zeal.store.vo.CartVO;

import java.util.List;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/17 9:31
 */
public interface ICartService {
    /**
     * 将商品添加到购物车
     * @param uid 当前登录用户的id
     * @param pid 商品的id
     * @param amount 增加的数量
     * @param username 当前登录的用户名
     */
    void addToCart(Integer uid, Integer pid, Integer amount, String username);

    /**
     * 通过uid获取用户购物车信息
     * @param uid uid
     * @return 购物车信息
     */
    List<CartVO> getVOByUid(Integer uid);

    /**
     * 将购物车中某商品的数量加1
     * @param cid 购物车数量的id
     * @param uid 当前登录的用户的id
     * @param username 当前登录的用户名
     * @return 增加成功后新的数量
     */
    Integer addNum(Integer cid, Integer uid, String username);

    /**
     * 将购物车中某商品的数量减1
     * @param cid 购物车数量的id
     * @param uid 当前登录的用户的id
     * @param username 当前登录的用户名
     * @return 减少成功后新的数量
     */
    Integer delNum(Integer cid, Integer uid, String username);

    void delCart(Integer cid, Integer uid);

    /**
     * 根据若干个购物车数据id查询详情的列表
     * @param uid 当前登录的用户的id
     * @param cids 若干个购物车数据id
     * @return 匹配的购物车数据详情的列表
     */
    List<CartVO> getVOByCids(Integer uid, Integer[] cids);

}
