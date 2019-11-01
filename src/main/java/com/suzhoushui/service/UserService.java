package com.suzhoushui.service;

import com.suzhoushui.domain.User;
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


    /**
     * 更该用户昵称
     * 要求不仅要修改用户表中的信息也要修改评论表中相对应的信息
     * @param username
     * @param token
     * @return
     */
    public BaseResponse updateUserName(String username,String token);

    /**
     * 修改用户个性签名
     * @param signature
     * @param token
     * @return
     */
    public BaseResponse updateUserSignature(String signature,String token);

}
