package com.suzhoushui.service;

import com.suzhoushui.domain.Comment;
import com.suzhoushui.domain.Scenic;
import com.suzhoushui.response.BaseResponse;

import java.util.List;

public interface ScenicService {

    /**
     * 分类查询
     * @param page
     * @return
     */
    public List<Scenic>  pagingScenic(int page);


    /**
     * 根据id查询一个美景
     * @param id
     * @return
     */
    public Scenic getOneScenic(Long id);

    /**
     * 根据景区id查询评论
     * @param scenic_id
     * @return
     */
    public List<Comment> getComment(Long scenic_id);

}
