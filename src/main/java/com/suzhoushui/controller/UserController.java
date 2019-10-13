package com.suzhoushui.controller;

import com.suzhoushui.domain.User;
import com.suzhoushui.enums.ExpTime;
import com.suzhoushui.enums.StatusCode;
import com.suzhoushui.mapper.UserMapper;
import com.suzhoushui.response.BaseResponse;
import com.suzhoushui.service.UserService;
import com.suzhoushui.util.CheckToken;
import com.suzhoushui.util.UserTokenUtilImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {


    @Autowired
    private UserTokenUtilImpl userTokenUtil;

    @Autowired
    private UserService userService;

    @CheckToken
    @GetMapping("findByUsername")
    public BaseResponse findByName(String username,String token){


        BaseResponse baseResponse = userService.findByName(username,token);

        return baseResponse;
    }


    @GetMapping("/test")
    public BaseResponse test(String username){
        BaseResponse baseResponse = new BaseResponse(StatusCode.LikeSuccess);

        User user=userService.test(username);

        System.out.println(user.getId());

        return baseResponse;
    }

    @PostMapping("/login")
    public BaseResponse login(String username, String password){
        BaseResponse baseResponse=userService.login(username,password);
        return baseResponse;
    }

    @PostMapping("/register")
    public BaseResponse register(String username,String password){
        BaseResponse baseResponse=userService.register(username,password);
        return baseResponse;
    }

}
