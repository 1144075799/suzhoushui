package com.suzhoushui.service;

import com.suzhoushui.response.BaseResponse;

public interface UserService {

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public BaseResponse login(String username, String password);

}
