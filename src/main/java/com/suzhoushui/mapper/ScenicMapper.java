package com.suzhoushui.mapper;

import com.suzhoushui.domain.Comment;
import com.suzhoushui.domain.Scenic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface ScenicMapper {


    @Select("SELECT * FROM scenic Where id = #{id}")
    Scenic findById(Long id);

    @Select("SELECT * from scenic ORDER BY people DESC LIMIT 10")
    List<Scenic> findTopTen();

    @Select("SELECT * FROM scenic LIMIT #{page},#{num}")
    List<Scenic> paging(int page,int num);

    @Select("SELECT * FROM comment Where scenic_id= #{scenic_id}")
    List<Comment> getComment(Long scenic_id);

    @Insert("INSERT INTO comment (name,image,time,comment,scenic_id) values (#{name},#{image},#{time},#{comment},#{scenic_id})")
    Integer addComent(String name, String image, String time,String comment,Long scenic_id);
}
