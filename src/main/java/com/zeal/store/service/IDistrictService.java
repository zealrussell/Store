package com.zeal.store.service;

import com.zeal.store.entity.District;

import java.util.List;


/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/12 8:37
 */
public interface IDistrictService {

    /**
     * 根据父代号，查询区信息
     * @param parent 父代号
     * @return list
     */
    List<District> getByParent(String parent);

    /**
     * 通过区号找区名
     * @param code 区号
     * @return 名字
     */
    String getNameByCode(String code);
}
