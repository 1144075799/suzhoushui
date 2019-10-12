package com.suzhoushui.controller;


import com.suzhoushui.domain.Comment;
import com.suzhoushui.domain.Scenic;
import com.suzhoushui.mapper.ScenicMapper;
import com.suzhoushui.response.BaseResponse;
import com.suzhoushui.service.impl.ScenicService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "景点模板")
@RestController
@RequestMapping("/api")
public class ScenicController {

    @Autowired
    private ScenicMapper scenicMapper;

    @Autowired
    private ScenicService scenicService;


    @GetMapping("/findByIdScenic")
    public BaseResponse findById(Long id){
        return scenicService.getOneScenic(id);
    }

    @GetMapping("/pagingScenic")
    public Object pagingScenic(int page){
        return scenicService.pagingScenic(page);

    }

    @GetMapping("/getComment")
    public Object getComment(Long scenic_id){
        return scenicMapper.getComment(scenic_id);
    }
}
