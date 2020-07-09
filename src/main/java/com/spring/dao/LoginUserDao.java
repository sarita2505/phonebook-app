package com.spring.dao;

import com.spring.module.LoginUser;
import com.spring.module.PhoneBook;
import com.spring.utils.LoginUserRowMapper;
import com.spring.utils.PhoneBookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class LoginUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String register = "insert INTO userlogin(userName,email,password) VALUES(?,?,?)";
    private static final String getUser = "select * from userlogin where email=?";


    public Integer registerUser(LoginUser user) {
        return jdbcTemplate.update(register,new Object[]{user.getUserName(),user.getEmail(),user.getPassword()});
    }

    public LoginUser getUserByEmail(String email) {
        return jdbcTemplate.queryForObject(getUser, new Object[]{email}, new LoginUserRowMapper());
    }


}
