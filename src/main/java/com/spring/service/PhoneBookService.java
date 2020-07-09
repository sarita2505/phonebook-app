package com.spring.service;

import com.spring.dao.PhoneBookDao;
import com.spring.module.PhoneBook;
import com.spring.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PhoneBookService {
    @Autowired
    private PhoneBookDao phoneBookDao;
    public List<PhoneBook> getFriendList(){
       Integer loginUserId= UserContext.getUserId();
        return phoneBookDao.getFriendList(loginUserId);
    }
}
