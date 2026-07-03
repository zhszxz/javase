package com.bistu.spring6.resourse.controller;

import com.bistu.spring6.resourse.service.userService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller(value = "myUserController")
public class userController {
    //controller里注入service，根据名称注入
   /* @Resource(name = "myUserService")
    private userService myUserService;*/

    //未指定name，属性名也没有保持一致，根据类型注入
    @Resource
    private userService UserService;
    public void addUserController() {
        System.out.println("controller...");
        //myUserService.addUserService();

        UserService.addUserService();
    }
}
