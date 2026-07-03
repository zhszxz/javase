package com.bistu.spring6iocxml.auto.control;

import com.bistu.spring6iocxml.auto.service.UserService;
import com.bistu.spring6iocxml.auto.service.UserServiceImpl;

public class control {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        System.out.println("controller执行了.。。。");
        userService.addUserService();
    }
}
