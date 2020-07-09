package com.spring.handler;

import com.spring.module.LoginUser;
import com.spring.utils.Base64Utils;
import com.spring.module.MyUserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        if (authentication!=null){
            MyUserPrincipal myUserPrincipal = (MyUserPrincipal) authentication.getPrincipal();
            LoginUser loginUser=myUserPrincipal.getLoginUser();
            String value=loginUser.getEmail();
            String email= Base64Utils.encode(value);
            //byte[] email=Base64.getEncoder().encode(value.getBytes(value));
            httpServletResponse.setHeader("authentication",email);
            httpServletResponse.getWriter().write(email);
        }
        else {
            httpServletResponse.getWriter().write("authentication failed");
        }
    }
}
