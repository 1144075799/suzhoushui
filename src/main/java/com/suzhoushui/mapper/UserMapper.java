package com.suzhoushui.mapper;

import com.suzhoushui.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> getAll();

    @Select("SELECT * FROM user where id=#{id}")
    User fingById(int id);


    @Select("SELECT * FROM user where username=#{username}")
    User selectByUserName(String username);


    @Insert("INSERT INTO user (username,password) values (#{username},#{password})")
    Integer addUser(String username,String password);

    @Update("Update user set nickname=#{username} where id=#{id}")
    Integer updateUser(String username,int id);


    @Update("Update user set signature=#{signature} where id=#{id}")
    Integer updateUserSig(String signature,int id);



}
