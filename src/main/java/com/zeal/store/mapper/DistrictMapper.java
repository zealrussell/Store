package com.zeal.store.mapper;

import com.zeal.store.entity.District;

import java.util.List;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/12 8:30
 */
public interface DistrictMapper {

    /**
     * 根据父查询子
     * @param parent 父
     * @return 子
     */
    List<District> findByParent(String parent);

    /**
     * 通过code找name
     * @param code 区号
     * @return 区名
     */
    String findNameByCode(String code);

}
