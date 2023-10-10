package com.lemon.service;

import com.lemon.spring.Autowired;
import com.lemon.spring.Component;
import com.lemon.spring.Scope;

/**
 * Created by lemoon on 2023/10/7 22:25
 */

@Component("userService")
public class UserService {

    @Autowired
    private OrderService orderService;

    public void test() {
        System.out.println(orderService);
    }
}
