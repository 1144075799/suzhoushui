package com.suzhoushui.controller;


import com.suzhoushui.domain.Food;
import com.suzhoushui.domain.FoodAddress;
import com.suzhoushui.domain.FoodImage;
import com.suzhoushui.enums.StatusCode;
import com.suzhoushui.response.BaseResponse;
import com.suzhoushui.service.impl.FoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "美食模板")
@RestController
@RequestMapping("/api")
public class FoodController {


    @Autowired
    private FoodService foodService;



    @GetMapping("/getAllFood")
    @ApiOperation(value = "返回所有美食的接口",notes = "Get请求")
    public Object getAll(){
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        List<Food> foodList=foodService.getAll();
        baseResponse.setData(foodList);
        return baseResponse;
    }

    @GetMapping("getOneFood")
    @ApiOperation(value = "返回一个美食的接口",notes = "get请求参数中带上id")
    public BaseResponse getOne(Long id){
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        FoodImage food=foodService.getOne(id);
        Map map = new HashMap();
        map.put("food",food);
        baseResponse.setData(map);
        return baseResponse;
    }


    @GetMapping("findFoodAddress")
    @ApiOperation(value = "返回美食的地址接口",notes = "get请求参数中带上美食的id")
    public Object getAddress(Long food_id){
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        List<FoodAddress> foodAddressList = foodService.getAddress(food_id);
        baseResponse.setData(foodAddressList);
        return foodService.getAddress(food_id);
    }

    @GetMapping("findOneAddress")
    @ApiOperation(value = "返回一个美食地址的接口",notes = "get请求参数中带上美食地址的id")
    public BaseResponse getOneAddress(Long id){
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        FoodAddress foodAddress=foodService.getOneAddress(id);
        Map map = new HashMap();
        map.put("foodAddress",foodAddress);
        baseResponse.setData(map);
        return baseResponse;
    }

    @GetMapping("findFoodTopTen")
    public BaseResponse findTopTen(){
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        List<Food> foodList=foodService.findTopTen();
        Map map = new HashMap();
        map.put("foodList",foodList);
        baseResponse.setData(map);
        return baseResponse;
    }
}
