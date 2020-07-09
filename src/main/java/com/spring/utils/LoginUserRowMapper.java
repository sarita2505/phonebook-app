package com.spring.utils;

import com.spring.module.LoginUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUserRowMapper implements RowMapper<LoginUser> {
    @Override
    public LoginUser mapRow(ResultSet resultSet, int i) throws SQLException {
        LoginUser user=new LoginUser();
        user.setId(resultSet.getInt(1));
        user.setUserName(resultSet.getString(2));
        user.setEmail(resultSet.getString(3));
        user.setPassword(resultSet.getString(4));
        return user;
    }
}
