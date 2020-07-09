package com.spring.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.module.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {
    private LoginUser loginUser;
    private static ObjectMapper mapper=new ObjectMapper();
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

       LoginUser user=null;
        try {
            loginUser=mapper.readValue(request.getReader(),LoginUser.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.attemptAuthentication(request, response);
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        return loginUser.getEmail();
    }

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        return loginUser.getPassword();
    }
}
