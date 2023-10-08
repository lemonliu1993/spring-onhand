package com.lemon.service;

import com.lemon.spring.LemonApplicationContext;

/**
 * Created by lemoon on 2023/10/7 22:25
 */
public class Test {

    public static void main(String[] args) {
        LemonApplicationContext applicationContext = new LemonApplicationContext(AppConfig.class);

        UserService userService = (UserService) applicationContext.getBean("userService");

        System.out.println(applicationContext.getBean("userService"));
        System.out.println(applicationContext.getBean("userService"));
        System.out.println(applicationContext.getBean("userService"));
        System.out.println(applicationContext.getBean("userService"));

    }
}
