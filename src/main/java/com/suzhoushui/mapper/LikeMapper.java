package com.suzhoushui.mapper;

import org.apache.ibatis.annotations.Insert;

public interface LikeMapper {


    @Insert("INSERT INTO like_food (type_id,name,image,user_id) values (#{type_id},#{name},#{image},#{user_id})")
    Integer addLikeFood(Long type_id,String name,String image,Integer user_id);

    @Insert("INSERT INTO like_scenic (type_id,name,image,user_id) values (#{type_id},#{name},#{image},#{user_id})")
    Integer addLikeScenic(Long type_id,String name,String image,Integer user_id);

}
