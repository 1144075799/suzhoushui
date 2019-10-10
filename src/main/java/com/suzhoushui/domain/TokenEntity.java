package com.suzhoushui.domain;


import java.util.Date;

public class TokenEntity {
    String username;//用户名
    String token;//token的值
    Date createDate;//创建时间
    Date expiresDate;//过期时间

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getExpiresDate() {
        return expiresDate;
    }

    public void setExpiresDate(Date expiresDate) {
        this.expiresDate = expiresDate;
    }

    public TokenEntity(Date createDate) {
        this.createDate = createDate;
    }

    public TokenEntity(String username, String token, Date expiresDate) {
        this.username = username;
        this.token = token;
        this.createDate = new Date();
        this.expiresDate = expiresDate;
    }

    public TokenEntity(String username, String token, Date createDate, Date expiresDate) {
        this.username = username;
        this.token = token;
        this.createDate = createDate;
        this.expiresDate = expiresDate;
    }

}
