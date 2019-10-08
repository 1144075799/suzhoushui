package com.suzhoushui.mapper;

import com.suzhoushui.domain.Comment;
import com.suzhoushui.domain.Scenic;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ScenicMapper {


    @Select("SELECT * FROM scenic Where id = #{id}")
    Scenic findById(Long id);

    @Select("SELECT * FROM scenic LIMIT #{page},#{num}")
    List<Scenic> paging(int page,int num);

    @Select("SELECT * FROM comment Where scenic_id= #{scenic_id}")
    List<Comment> getComment(Long scenic_id);
}
