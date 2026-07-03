package com.bistu.spring6.autowired.controller;

import com.bistu.spring6.autowired.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class userController {
    /*//第一种：属性上注入
    /@Autowired
    private userService userService;*/
   /* //第2种：set方法上注入
    private userService userService;
    @Autowired
    public void setUserService(userService userService) {
        this.userService = userService;
    }*/
    /*//第3种：构造方法上注入
    private userService userService;

    @Autowired
    public userController(com.bistu.spring6.autowired.service.userService userService) {
        this.userService = userService;
    }*/
/*
     // 第4种：参数上注入
    private userService userService;

    public userController(@Autowired userService userService) {
        this.userService = userService;
    }*/
     // 第5种：若构造方法只有一个，可以不加注解完成注入
    private userService userService;

    public userController(com.bistu.spring6.autowired.service.userService userService) {
        this.userService = userService;
    }

    public void addUserController() {
        System.out.println("controller...");
        userService.addUserService();
    }
}
