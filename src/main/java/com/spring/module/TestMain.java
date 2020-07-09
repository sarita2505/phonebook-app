package com.spring.module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) {
        LoginUser user=new LoginUser(1,"hhh","hhh@gmail.com","haribol");
        PhoneBookData phoneBook=new PhoneBookData();
        String[] userdata= phoneBook.getUserInfo(user);
        System.out.println(Arrays.toString(userdata));
//        List<String> list=new ArrayList<>();
//        list.add("aa");
//        list.add("bb");
//        List<String> list1=new ArrayList<>();
//        list.add("1234567891");
//        list.add("1234567892");
        PhoneBook book=new PhoneBook(1,"aa","1234567890",1);
        PhoneBook book1=new PhoneBook(2,"bb","1234567891",1);
        PhoneBookData phoneBookData=new PhoneBookData();
        //Map map=phoneBookData.getPhoneBookInfo(new PhoneBook[]{book,book1});
        //System.out.println(map);
        PhoneBookData data=new PhoneBookData();
       Map map= data.getPhoneBookInfo(new PhoneBook[]{book,book1});
        System.out.println(map);


    }
}
