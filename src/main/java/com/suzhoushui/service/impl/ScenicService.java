package com.suzhoushui.service.impl;

import com.suzhoushui.domain.Comment;
import com.suzhoushui.domain.Scenic;
import com.suzhoushui.domain.User;
import com.suzhoushui.enums.StatusCode;
import com.suzhoushui.mapper.ScenicMapper;
import com.suzhoushui.response.BaseResponse;
import com.suzhoushui.util.UserTokenUtilImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScenicService implements com.suzhoushui.service.ScenicService {

    @Autowired
    private ScenicMapper scenicMapper;

    @Autowired
    private UserTokenUtilImpl userTokenUtil;

    @Override
    public List<Scenic>  pagingScenic(int page) {
        int num=page-1;
        int startPage=num*5;
        List<Scenic> scenicList=scenicMapper.paging(startPage,5);
        return scenicList;
    }

    @Override
    public List<Scenic> fingScenicTopTen() {

        List<Scenic> scenicList=scenicMapper.findTopTen();

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

    @Override
    public Integer addComment(Long scenic_id,String comment, String token) {
        User user= userTokenUtil.getUser(token);

        //拿到用户的基本信息
        String name=user.getNickname();
        String image=user.getImage();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格
        String time=df.format(new Date());    // new Date()为获取当前系统时间

        Integer type=scenicMapper.addComent(name,image,time,comment,scenic_id);


        return type;
    }
}
