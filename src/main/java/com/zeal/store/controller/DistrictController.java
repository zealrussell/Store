package com.zeal.store.controller;

import com.zeal.store.entity.District;
import com.zeal.store.service.IDistrictService;
import com.zeal.store.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * WHAT THE ZZZZEAL
 *
 * @author zeal
 * @version 1.0
 * @date 2022/4/12 8:47
 */

@RequestMapping("districts")
@RestController
public class DistrictController extends BaseController{

    @Autowired
    private IDistrictService districtService;

    @RequestMapping({"","/"})
    public JSONResult<List<District>> getByParent(String parent) {
        List<District> data = districtService.getByParent(parent);
        return new JSONResult<>(OK,data);
    }
}
