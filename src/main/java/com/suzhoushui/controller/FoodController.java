package com.suzhoushui.controller;


import com.suzhoushui.response.BaseResponse;
import com.suzhoushui.service.impl.FoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "美食模板")
@RestController
@RequestMapping("/api")
public class FoodController {


    @Autowired
    private FoodService foodService;



    @GetMapping("/getAllFood")
    @ApiOperation(value = "返回所有美食的接口",notes = "Get请求")
    public Object getAll(){
        return foodService.getAll();
    }

    @GetMapping("getOneFood")
    @ApiOperation(value = "返回一个美食的接口",notes = "get请求参数中带上id")
    public BaseResponse getOne(Long id){
        return foodService.getOne(id);
    }


    @GetMapping("findFoodAddress")
    @ApiOperation(value = "返回美食的地址接口",notes = "get请求参数中带上美食的id")
    public Object getAddress(Long food_id){
        return foodService.getAddress(food_id);
    }

    @GetMapping("findOneAddress")
    @ApiOperation(value = "返回一个美食地址的接口",notes = "get请求参数中带上美食地址的id")
    public BaseResponse getOneAddress(Long id){
        return foodService.getOneAddress(id);
    }
}
