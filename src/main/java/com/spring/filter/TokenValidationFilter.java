package com.spring.filter;

import com.spring.dao.LoginUserDao;
import com.spring.module.LoginUser;
import com.spring.utils.Base64Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@Component
public class TokenValidationFilter extends OncePerRequestFilter {
    @Autowired
    private LoginUserDao userDao;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) httpServletRequest;
        String value = request.getHeader("Authorization");
        if (value != null) {
            String email = Base64Utils.decode(value);
            LoginUser principal = userDao.getUserByEmail(email);

            principal.setPassword(null);
            UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(principal, null, Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
            result.setDetails(principal);
            //    result.setAuthenticated(true);
            SecurityContextHolder.getContext().setAuthentication(result);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
