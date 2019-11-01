package com.suzhoushui.controller;

import com.suzhoushui.domain.Like;
import com.suzhoushui.enums.StatusCode;
import com.suzhoushui.response.BaseResponse;
import com.suzhoushui.service.impl.LikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "喜欢模板")
@RestController
@RequestMapping("/api")
public class LikeController {


    @Autowired
    private LikeService likeService;

    @GetMapping("/likeFood")
    @ApiOperation(value = "添加喜欢美食接口",notes = "get请求参数中带上美食的id，和用户的token")
    public BaseResponse likeFood(Long type_id,String token){

        BaseResponse baseResponse=null;

        Integer type=likeService.addLikeFood(type_id,token);

        if (type==1){                                                   //对返回参数进行判断
            baseResponse = new BaseResponse(StatusCode.LikeSuccess);
            return baseResponse;
        }

        baseResponse = new BaseResponse(StatusCode.LikeFail);

        return baseResponse;
    }


    @GetMapping("/likeScenic")
    @ApiOperation(value = "添加喜欢美景接口",notes = "get请求参数中带上美食的id，和用户的token")
    public BaseResponse likeScenic(Long type_id,String token){
        BaseResponse baseResponse=null;

        Integer type =  likeService.addLikeScenic(type_id,token);

        if (type==1){
            baseResponse = new BaseResponse(StatusCode.LikeSuccess);
            return baseResponse;
        }

        baseResponse = new BaseResponse(StatusCode.LikeFail);

        return baseResponse;
    }

    @GetMapping("/deleteFood")
    @ApiOperation(value = "删除喜欢美食接口",notes = "get请求参数中带上美食的id，和用户的token")
    public BaseResponse deleteFood(Long type_id,String token){

        BaseResponse baseResponse=null;

        Integer type=likeService.deleteLikeFood(type_id,token);

        if (type==1){                                                   //对返回参数进行判断
            baseResponse = new BaseResponse(StatusCode.DeleteSuccess);
            return baseResponse;
        }

        baseResponse = new BaseResponse(StatusCode.DeleteLikeFail);

        return baseResponse;
    }

    @GetMapping("/deleteScenic")
    @ApiOperation(value = "删除喜欢美景接口",notes = "get请求参数中带上美食的id，和用户的token")
    public BaseResponse deleteScenic(Long type_id,String token){

        BaseResponse baseResponse=null;

        Integer type=likeService.deleteLikeScenic(type_id,token);

        if (type==1){                                                   //对返回参数进行判断
            baseResponse = new BaseResponse(StatusCode.DeleteSuccess);
            return baseResponse;
        }

        baseResponse = new BaseResponse(StatusCode.DeleteLikeFail);

        return baseResponse;
    }

    @GetMapping("/getAllLikeFood")
    @ApiOperation(value = "返回喜欢美食接口",notes = "用户的token")
    public BaseResponse getAllLikeFood(String token){

        BaseResponse baseResponse=new BaseResponse(StatusCode.Success);

        List<Like> likes=likeService.getAllLikeFood(token);

        baseResponse.setData(likes);


        return baseResponse;
    }

    @GetMapping("/getAllLikeScenic")
    @ApiOperation(value = "返回喜欢美景接口",notes = "用户的token")
    public BaseResponse getAllLikeScenic(String token){

        BaseResponse baseResponse=new BaseResponse(StatusCode.Success);

        List<Like> likes=likeService.getAllLikeScenic(token);

        baseResponse.setData(likes);


        return baseResponse;
    }




}
