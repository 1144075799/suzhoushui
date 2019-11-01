package com.suzhoushui.mapper;

import com.suzhoushui.domain.Like;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LikeMapper {


    @Insert("INSERT INTO like_food (type_id,name,image,user_id) values (#{type_id},#{name},#{image},#{user_id})")
    Integer addLikeFood(Long type_id,String name,String image,Integer user_id);

    @Insert("INSERT INTO like_scenic (type_id,name,image,user_id) values (#{type_id},#{name},#{image},#{user_id})")
    Integer addLikeScenic(Long type_id,String name,String image,Integer user_id);


    @Delete("DELETE From like_food where type_id=#{type_id} AND user_id=#{user_id};")
    Integer deleteLikeFood(Long type_id,Integer user_id);

    @Delete("DELETE From like_scenic where type_id=#{type_id} AND user_id=#{user_id};")
    Integer deleteLikeScenic(Long type_id,Integer user_id);

    @Select("Select * from like_food where user_id=#{user_id};")
    List<Like> getLikeFood(Integer user_id);

    @Select("Select * from like_scenic where user_id=#{user_id};")
    List<Like> getLikeScenic(Integer user_id);

}
