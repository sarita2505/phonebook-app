package com.spring.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBookData {
    private String name;
    private String email;
    private String friendName;
    private String phoneNumber;
    private Map<String, String> friends=new HashMap<>();
    private LoginUser user;
    private PhoneBook phoneBook;

    public PhoneBookData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setUser(LoginUser user) {
        this.user = user;
    }

    public void setPhoneBook(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public String[] getUserInfo(LoginUser user){
        name = user.getUserName();
        email = user.getEmail();
        return new String[]{name,email};
    }

    public Map getPhoneBookInfo(PhoneBook[] phoneBook) {
        String[] phone_data=null;
        for (PhoneBook book:phoneBook) {
            friendName = book.getFriendName();
            phoneNumber =book.getPhoneNumber();
            //phone_data=new String[]{friendName,phoneNumber};
            friends.put(friendName, phoneNumber);


        }
        return friends;
    }


}
