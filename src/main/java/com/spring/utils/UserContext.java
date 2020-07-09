package com.spring.utils;

import com.spring.module.LoginUser;
import com.spring.module.MyUserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserContext {


    public static LoginUser getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser myUserPrincipal = (LoginUser) authentication.getPrincipal();
        return myUserPrincipal;
    }

    public static Integer getUserId() {
        return getLoginUser().getId();
    }

    public static String getEmail() {
        return getLoginUser().getEmail();
    }

    public static String getUserName() {
        return getLoginUser().getUserName();
    }
}
