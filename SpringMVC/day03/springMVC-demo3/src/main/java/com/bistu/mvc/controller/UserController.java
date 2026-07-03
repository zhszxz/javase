package com.bistu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    //Restful风格的用户信息增删改查
    // /user    GET     查询所有用户信息
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String SelectAll() {
        System.out.println("查询所有用户信息");
        return "success";
    }

    // /user/1    GET     根据id查询用户信息
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String SelectUserById(String id) {
        System.out.println(id);
        System.out.println("根据id查询用户信息");
        return "success";
    }
    // /user    POST     添加用户信息
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String AddUser(String username,String password) {
        System.out.println("添加用户信息："+username+" "+password);
        return "success";
    }
    // /user/1    DELETE     删除用户信息
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String DeleteUser(String username,String password) {
        System.out.println("删除用户信息："+username+" "+password);
        return "success";
    }
    // /user    PUT     修改用户信息
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String UpdateUser(String username,String password) {
        System.out.println("修改用户信息："+username+" "+password);
        return "success";
    }
}
