package com.suzhoushui.util;


import com.suzhoushui.domain.Role;
import com.suzhoushui.domain.TokenEntity;
import com.suzhoushui.enums.ExpTime;

public interface TokenUtil {
    public TokenEntity create(Role role, ExpTime expTime) throws Exception;

    public boolean verifie(String token);

    public boolean isExpire(String token);

    public String reSign(String token, ExpTime expTime);
}
