package com.suzhoushui.mapper;

import com.suzhoushui.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

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




}
