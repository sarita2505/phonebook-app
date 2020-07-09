package com.spring.utils;

import com.spring.module.PhoneBook;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneBookRowMapper implements RowMapper<PhoneBook> {
    @Override
    public PhoneBook mapRow(ResultSet resultSet, int i) throws SQLException {
        PhoneBook book=new PhoneBook();
//        book.setId(resultSet.getInt());
        book.setFriendName(resultSet.getString(1));
        book.setPhoneNumber(resultSet.getString(2));
//        book.setPhoneBookOwnerId(resultSet.getInt(4));
        return book;
    }
}
