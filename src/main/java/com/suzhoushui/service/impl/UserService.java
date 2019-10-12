package com.suzhoushui.service.impl;

import com.suzhoushui.domain.User;
import com.suzhoushui.enums.ExpTime;
import com.suzhoushui.enums.StatusCode;
import com.suzhoushui.mapper.UserMapper;
import com.suzhoushui.response.BaseResponse;
import com.suzhoushui.util.Base64Util;
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

    @Override
    public BaseResponse login(String username, String password) {
        String checkpassword=userMapper.selectByUserName(username).getPassword();
        String basepassword= Base64Util.decode(password);
        System.out.println("解密之后的密码:"+basepassword);
        String token=null;


        if(checkpassword.equals(password)){
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
}
