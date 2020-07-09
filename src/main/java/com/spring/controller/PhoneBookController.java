package com.spring.controller;

import com.spring.module.PhoneBook;
import com.spring.service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneBookController {
    @Autowired
    private PhoneBookService service;
    @GetMapping("/api/friends")
    public List<PhoneBook> getFriends(){
       return service.getFriendList();
    }
}
