package com.spring.utils;

import sun.misc.BASE64Encoder;

import java.util.Base64;

public class Base64Utils {

    public static String encode(String input)
    {
     byte[] encode= Base64.getEncoder().encode(input.getBytes());
     return new String(encode);
    }

    public static String decode(String input)
    {
       byte[] decodedData =  Base64.getDecoder().decode(input.getBytes());
       return new String(decodedData);
    }
}
