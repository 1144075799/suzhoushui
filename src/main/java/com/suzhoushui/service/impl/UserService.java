package com.suzhoushui.service.impl;

import com.suzhoushui.domain.User;
import com.suzhoushui.enums.ExpTime;
import com.suzhoushui.enums.StatusCode;
import com.suzhoushui.mapper.UserMapper;
import com.suzhoushui.response.BaseResponse;
import com.suzhoushui.util.Base64Util;
import com.suzhoushui.util.CheckToken;
import com.suzhoushui.util.MD5Util;
import com.suzhoushui.util.UserTokenUtilImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class UserService implements com.suzhoushui.service.UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserTokenUtilImpl userTokenUtil;


    /**
     * 登陆服务
     * @param username
     * @param password
     * @return
     */
    @Override
    public BaseResponse login(String username, String password) {
        String checkpassword=userMapper.selectByUserName(username).getPassword(); //从数据库中拿到MD5加密之后的密码

        String basepassword= Base64Util.decode(password);                   //Base64 解密

        String mdpassword= MD5Util.encode(basepassword);                    // MD5 加密

        String token=null;


        if(checkpassword.equals(mdpassword)){
            User user = new User();
            user.setPassword(password);
            user.setUsername(username);
            token= userTokenUtil.create(user, ExpTime.OneDay).getToken();
        }

        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        Map map = new HashMap();
        map.put("token",token);
        baseResponse.setData(map);
        return baseResponse;
    }


    /**
     * 注册服务
     * @param username
     * @param password
     * @return
     */
    @Override
    public BaseResponse register(String username, String password) {

        String basepassword= Base64Util.decode(password);                   //Base64 解密

        String mdpassword= MD5Util.encode(basepassword);                    // MD5 加密

        BaseResponse baseResponse=null;

        User user=userMapper.selectByUserName(username);

        if(user!=null){
            baseResponse = new BaseResponse(StatusCode.UserNameIsExit);
            return baseResponse;
        }

        Integer type=userMapper.addUser(username,mdpassword);

        if(type==1){
            baseResponse=new BaseResponse(StatusCode.LoginSuccess);

        }

        return baseResponse;
    }

    @Override
    public BaseResponse findByName(String username, String token) {
//        User user = userTokenUtil.getUser(token);

//        System.out.println(user.getUsername());

        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        Map map = new HashMap();
        Integer id = userMapper.selectByUserName("admin").getId();

        User user1 = userMapper.selectByUserName("admin");

        System.out.println("用户id是"+id);

        map.put("token",token);
        map.put("user",user1);
        baseResponse.setData(map);
        return baseResponse;
    }

    @Override
    public BaseResponse test(String username) {

        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);
        User user=userMapper.selectByUserName(username);

        Map map=new HashMap();

        map.put("user",user);
        baseResponse.setData(map);

        return baseResponse;
    }
}