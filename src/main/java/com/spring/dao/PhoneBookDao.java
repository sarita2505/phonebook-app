package com.spring.dao;

import com.spring.module.PhoneBook;
import com.spring.utils.PhoneBookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhoneBookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String getFriendList="select friendName,phoneNumber from phonebook where phoneBookOwnerId=?";

    public List<PhoneBook> getFriendList(int id){
        return jdbcTemplate.query(getFriendList,new Object[]{id},new PhoneBookRowMapper());
    }
}
