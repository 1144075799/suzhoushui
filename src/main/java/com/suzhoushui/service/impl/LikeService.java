package com.suzhoushui.service.impl;

import com.suzhoushui.domain.Food;
import com.suzhoushui.domain.Scenic;
import com.suzhoushui.domain.User;
import com.suzhoushui.enums.StatusCode;
import com.suzhoushui.mapper.FoodMapper;
import com.suzhoushui.mapper.LikeMapper;
import com.suzhoushui.mapper.ScenicMapper;
import com.suzhoushui.response.BaseResponse;
import com.suzhoushui.util.UserTokenUtilImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LikeService implements com.suzhoushui.service.LikeService {

    @Autowired
    private LikeMapper likeMapper;

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private ScenicMapper scenicMapper;

    @Autowired
    private UserTokenUtilImpl userTokenUtil;

    @Override
    public BaseResponse addLikeFood(Long type_id, String token) {

        User user= userTokenUtil.getUser(token);

        Integer user_id=user.getId();

        BaseResponse baseResponse=null;

        Food food= foodMapper.findById(type_id);

        String name=food.getTitle();

        String image=food.getImage();


        Integer type =likeMapper.addLikeFood(type_id,name,image,user_id);

        if (type==1){
            baseResponse = new BaseResponse(StatusCode.LikeSuccess);
            return baseResponse;
        }

        baseResponse = new BaseResponse(StatusCode.LikeFail);

        return baseResponse;
    }

    @Override
    public BaseResponse addLikeScenic(Long type_id, String token) {

        User user= userTokenUtil.getUser(token);

        Integer user_id=user.getId();


        BaseResponse baseResponse=null;

        Scenic scenic = scenicMapper.findById(type_id);

        String name = scenic.getName();

        String image = scenic.getImage();

        Integer type = likeMapper.addLikeScenic(type_id,name,image,user_id);

        if (type==1){
            baseResponse = new BaseResponse(StatusCode.LikeSuccess);
            return baseResponse;
        }

        baseResponse = new BaseResponse(StatusCode.LikeFail);

        return baseResponse;
    }
}
