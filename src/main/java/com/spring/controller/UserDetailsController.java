package com.spring.controller;

import com.spring.dao.LoginUserDao;
import com.spring.module.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailsController {
    @Autowired
    private LoginUserDao userDao;
    @GetMapping("/hello")
    public String getData() {
        return ("<h1> helloworld </h1>");
    }
    @GetMapping("/")
    public String defaultPage() {
        return ("<h1> hello all </h1>");
    }
    @GetMapping("/accessDenied")
    public String accessDenied() {
        return ("<h1> accessDenied </h1>");
    }

    @GetMapping("/loginFailed")
    public String loginFailed() {
        return ("<h1> loginFailed</h1>");
    }
    @PostMapping("/register")
    public ResponseEntity<Integer> save(@RequestBody LoginUser user){
        Integer i= userDao.registerUser(user);
        return ResponseEntity.ok(i);
    }
}
