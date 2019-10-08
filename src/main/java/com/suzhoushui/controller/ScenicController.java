package com.suzhoushui.controller;


import com.suzhoushui.domain.Comment;
import com.suzhoushui.domain.Scenic;
import com.suzhoushui.mapper.ScenicMapper;
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

    @GetMapping("/findByIdScenic")
    public Scenic findById(Long id){
        return scenicMapper.findById(id);
    }

    @GetMapping("/pagingScenic")
    public List<Scenic> pagingScenic(int page){
        int num=page-1;
        int startPage=num*5;
        return scenicMapper.paging(startPage,5);

    }

    @GetMapping("/getComment")
    public List<Comment> getComment(Long scenic_id){
        return scenicMapper.getComment(scenic_id);
    }
}
