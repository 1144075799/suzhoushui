package com.suzhoushui.service;

import com.suzhoushui.domain.Like;
import com.suzhoushui.response.BaseResponse;

import javax.swing.*;
import java.util.List;

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

    /**
     * 删除用户喜欢的美食
     * @param type_id
     * @param token
     * @return
     */
    public Integer deleteLikeFood(Long type_id,String token);

    /**
     * 删除用户喜欢的美景
     * @param type_id
     * @param token
     * @return
     */
    public Integer deleteLikeScenic(Long type_id,String token);


    /**
     * 根据用户token返回所有喜欢的美食
     * @param token
     * @return
     */
    public List<Like> getAllLikeFood(String token);

    /**
     * 根据用户token返回所有喜欢的景区
     * @param token
     * @return
     */
    public List<Like> getAllLikeScenic(String token);

}
