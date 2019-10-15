package com.suzhoushui.service;

import com.suzhoushui.response.BaseResponse;

import javax.swing.*;

public interface LikeService {


    /**
     * 添加用户喜欢美食
     * @param type_id
     * @param token
     * @return
     */
    public Integer addLikeFood(Long type_id, String token);

    /**
     * 添加用户喜欢的美景
     * @param type_id
     * @param token
     * @return
     */
    public Integer addLikeScenic(Long type_id,String token);

}
