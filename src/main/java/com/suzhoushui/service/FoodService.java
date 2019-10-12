package com.suzhoushui.service;

import com.suzhoushui.response.BaseResponse;

public interface FoodService {

    /**
     * 返回所有食物
     * @return
     */
    public Object getAll();

    /**
     * 根据id查询一个美食
     * @param id
     * @return
     */
    public BaseResponse getOne(Long id);

    /**
     * 返回美食的地址集
     * @param id
     * @return
     */
    public Object getAddress(Long id);

    /**
     * 根据地址id查询美食地址
     * @param id
     * @return
     */
    public BaseResponse getOneAddress(Long id);

}
