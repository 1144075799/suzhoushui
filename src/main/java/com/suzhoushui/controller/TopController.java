package com.suzhoushui.controller;

import com.suzhoushui.domain.Food;
import com.suzhoushui.domain.Scenic;
import com.suzhoushui.domain.Specialty;
import com.suzhoushui.enums.StatusCode;
import com.suzhoushui.response.BaseResponse;
import com.suzhoushui.service.impl.FoodService;
import com.suzhoushui.service.impl.ScenicService;
import com.suzhoushui.service.impl.SpecialtyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "top10模板")
@RestController
@RequestMapping("/api")
public class TopController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private ScenicService scenicService;

    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping("findTopTen")
    @ApiOperation(value = "返回所有TOP10的接口",notes = "Get请求")
    public BaseResponse findTopTen(){
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        List<Food> foodList=foodService.findTopTen();
        List<Scenic> scenicList=scenicService.fingScenicTopTen();
        List<Specialty> specialtyList=specialtyService.getAll();
        Map map = new HashMap();
        map.put("foodList",foodList);
        map.put("scenicList",scenicList);
        map.put("specialtyList",specialtyList);
        baseResponse.setData(map);
        return baseResponse;
    }
}
