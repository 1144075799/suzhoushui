package com.suzhoushui.mapper;

import org.apache.ibatis.annotations.Insert;

public interface LikeMapper {


    @Insert("INSERT INTO like_food (type_id,name,image,user_name) values (#{type_id},#{name},#{image},#{user_name})")
    Integer addLikeFood(Long type_id,String name,String image,String user_name);

    @Insert("INSERT INTO like_scenic (type_id,name,image,user_name) values (#{type_id},#{name},#{image},#{user_name})")
    Integer addLikeScenic(Long type_id,String name,String image,String user_name);

}
