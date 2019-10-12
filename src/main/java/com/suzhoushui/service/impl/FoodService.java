package com.suzhoushui.service.impl;

import com.suzhoushui.domain.Food;
import com.suzhoushui.domain.FoodAddress;
import com.suzhoushui.enums.StatusCode;
import com.suzhoushui.mapper.FoodMapper;
import com.suzhoushui.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FoodService implements com.suzhoushui.service.FoodService {

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public Object getAll() {
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        List<Food> foodList=foodMapper.getAllFood();
        baseResponse.setData(foodList);
        return baseResponse;
    }

    @Override
    public BaseResponse getOne(Long id) {
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        Food food=foodMapper.findById(id);
        Map map = new HashMap();
        map.put("food",food);
        baseResponse.setData(map);
        return baseResponse;
    }

    @Override
    public Object getAddress(Long food_id) {
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        List<FoodAddress> foodList=foodMapper.findFoodAddress(food_id);
        baseResponse.setData(foodList);
        return baseResponse;
    }

    @Override
    public BaseResponse getOneAddress(Long id) {
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        FoodAddress foodAddress=foodMapper.findOneAddress(id);
        Map map = new HashMap();
        map.put("foodAddress",foodAddress);
        baseResponse.setData(map);
        return baseResponse;
    }
}
