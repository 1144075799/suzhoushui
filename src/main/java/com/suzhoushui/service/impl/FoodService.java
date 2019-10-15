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
    public List<Food> getAll() {
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        List<Food> foodList=foodMapper.getAllFood();
        return foodList;
    }

    @Override
    public Food getOne(Long id) {

        Food food=foodMapper.findById(id);

        return food;
    }

    @Override
    public List<FoodAddress> getAddress(Long food_id) {

        List<FoodAddress> foodList=foodMapper.findFoodAddress(food_id);

        return foodList;
    }

    @Override
    public FoodAddress getOneAddress(Long id) {
        FoodAddress foodAddress=foodMapper.findOneAddress(id);

        return foodAddress;
    }
}
