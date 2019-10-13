package com.suzhoushui.service;

import com.suzhoushui.response.BaseResponse;

public interface UserService {

    /**
     *登陆
     * @param username
     * @param password
     * @return
     */
    public BaseResponse login(String username, String password);


    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    public BaseResponse register(String username,String password);

    /**
     * 根据用户名获取信息
     * @param username
     * @param token
     * @return
     */
    public BaseResponse findByName(String username,String token);


    public BaseResponse test(String username);

}
