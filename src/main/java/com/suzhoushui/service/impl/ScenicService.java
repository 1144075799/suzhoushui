package com.suzhoushui.service.impl;

import com.suzhoushui.domain.Comment;
import com.suzhoushui.domain.Scenic;
import com.suzhoushui.enums.StatusCode;
import com.suzhoushui.mapper.ScenicMapper;
import com.suzhoushui.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScenicService implements com.suzhoushui.service.ScenicService {

    @Autowired
    private ScenicMapper scenicMapper;

    @Override
    public List<Scenic>  pagingScenic(int page) {
        int num=page-1;
        int startPage=num*5;
        List<Scenic> scenicList=scenicMapper.paging(startPage,5);
        return scenicList;
    }

    @Override
    public Scenic getOneScenic(Long id) {
        Scenic scenic=scenicMapper.findById(id);
        return scenic;
    }

    @Override
    public List<Comment> getComment(Long scenic_id) {

        List<Comment> commentList=scenicMapper.getComment(scenic_id);

        return commentList;
    }
}
