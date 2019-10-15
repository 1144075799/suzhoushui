package com.suzhoushui.service;

import com.suzhoushui.domain.Food;
import com.suzhoushui.domain.FoodAddress;
import com.suzhoushui.response.BaseResponse;

import java.util.List;

public interface FoodService {

    /**
     * 返回所有食物
     * @return
     */
    public List<Food> getAll();

    /**
     * 根据id查询一个美食
     * @param id
     * @return
     */
    public Food getOne(Long id);

    /**
     * 返回美食的地址集
     * @param id
     * @return
     */
    public List<FoodAddress> getAddress(Long id);

    /**
     * 根据地址id查询美食地址
     * @param id
     * @return
     */
    public FoodAddress getOneAddress(Long id);

}
