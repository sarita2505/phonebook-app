package com.spring.service;

import com.spring.dao.LoginUserDao;
import com.spring.module.LoginUser;
import com.spring.module.MyUserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private LoginUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //get the email from user context and set it in s;
        LoginUser user = userDao.getUserByEmail(s);
        if (user.getEmail() != null) {
            return new MyUserPrincipal(user);
        } else {
            throw new RuntimeException("not a valid user");
        }
    }
}
