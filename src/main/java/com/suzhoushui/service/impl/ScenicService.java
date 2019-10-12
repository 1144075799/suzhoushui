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
    public Object pagingScenic(int page) {
        int num=page-1;
        int startPage=num*5;
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        List<Scenic> scenicList=scenicMapper.paging(startPage,5);
        baseResponse.setData(scenicList);
        return baseResponse;
    }

    @Override
    public BaseResponse getOneScenic(Long id) {
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        Scenic scenic=scenicMapper.findById(id);
        Map map = new HashMap();
        map.put("scenic",scenic);
        baseResponse.setData(map);
        return baseResponse;
    }

    @Override
    public Object getComment(Long scenic_id) {
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        List<Comment> scenicList=scenicMapper.getComment(scenic_id);
        baseResponse.setData(scenicList);
        return baseResponse;
    }
}
