package com.suzhoushui.controller;


import com.suzhoushui.domain.Comment;
import com.suzhoushui.domain.Scenic;
import com.suzhoushui.enums.StatusCode;
import com.suzhoushui.mapper.ScenicMapper;
import com.suzhoushui.response.BaseResponse;
import com.suzhoushui.service.impl.ScenicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "景点模板")
@RestController
@RequestMapping("/api")
public class ScenicController {

    @Autowired
    private ScenicMapper scenicMapper;

    @Autowired
    private ScenicService scenicService;


    @GetMapping("/findByIdScenic")
    @ApiOperation(value = "根据id查找一个景区接口")
    public BaseResponse findById(Long id){
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        Scenic scenic=scenicMapper.findById(id);
        Map map = new HashMap();
        map.put("scenic",scenic);
        baseResponse.setData(map);
        return baseResponse;
    }


    @GetMapping("/pagingScenic")
    @ApiOperation(value = "分页查找景区接口")
    public Object pagingScenic(int page){
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        List<Scenic> scenicList=scenicService.pagingScenic(page);
        baseResponse.setData(scenicList);
        return baseResponse;

    }

    @GetMapping("/findScenicTopTen")
    @ApiOperation(value = "返回景区Top10接口")
    public BaseResponse findTopTen(){
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        List<Scenic> scenicList=scenicService.fingScenicTopTen();
        baseResponse.setData(scenicList);
        return baseResponse;
    }

    @GetMapping("/getComment")
    @ApiOperation(value = "返回所有评论接口")
    public Object getComment(Long scenic_id){
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        List<Comment> commentList=scenicMapper.getComment(scenic_id);
        baseResponse.setData(commentList);
        return baseResponse;
    }

    @PostMapping("/addComment")
    @ApiOperation(value = "添加评论接口")
    public Object addComment(Long scenic_id,String comment,String token){
        Integer type=scenicService.addComment(scenic_id,comment,token);

        if(type==1){
            BaseResponse baseResponse = new BaseResponse(StatusCode.CommentSuccess);
            return baseResponse;
        }

        BaseResponse baseResponse = new BaseResponse(StatusCode.CommentFail);
        return baseResponse;
    }
}
