package com.suzhoushui.controller;

import com.suzhoushui.domain.User;
import com.suzhoushui.enums.ExpTime;
import com.suzhoushui.enums.StatusCode;
import com.suzhoushui.mapper.UserMapper;
import com.suzhoushui.response.BaseResponse;
import com.suzhoushui.service.UserService;
import com.suzhoushui.util.CheckToken;
import com.suzhoushui.util.UserTokenUtilImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @PostMapping("/login")
    @ApiOperation(value = "登陆接口")
    public BaseResponse login(String username, String password){
        BaseResponse baseResponse=userService.login(username,password);
        return baseResponse;
    }

    @PostMapping("/register")
    @ApiOperation(value = "注册接口")
    public BaseResponse register(String username,String password){
        BaseResponse baseResponse=userService.register(username,password);
        return baseResponse;
    }


    @PostMapping("/updateUserName")
    @ApiOperation(value = "修改用户昵称接口")
    public BaseResponse updateUser(String username,String token){
        BaseResponse baseResponse=userService.updateUserName(username,token);
        return baseResponse;
    }

    @PostMapping("/updateUserSig")
    @ApiOperation(value = "修改用户个性签名接口")
    public BaseResponse updateUserSig(String signature,String token){
        BaseResponse baseResponse=userService.updateUserSignature(signature,token);
        return baseResponse;
    }

    @PostMapping("/uploadimg")
    @ApiOperation(value = "上传用户头像")
    public BaseResponse uploadImg(@RequestParam("file") MultipartFile file,String token) throws IOException {
        return userService.uploadImage(file,token);
    }


}
