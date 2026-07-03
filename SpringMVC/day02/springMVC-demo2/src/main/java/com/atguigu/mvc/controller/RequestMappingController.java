package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/hello")
@Controller
public class RequestMappingController {
    //value属性和method属性的数组中的多个值匹配任意一个即可，不同的属性需要同时满足
    @RequestMapping(value = {"testRequestMapping", "test"},
            method = {RequestMethod.GET, RequestMethod.POST})
    public String success() {
        return "success";
    }

    @GetMapping("/testGetMapping")
    public String testGetMapping() {
        return "success";
    }

    /*@RequestMapping(value = {"testRequestMapping", "test"},
            method = {RequestMethod.GET, RequestMethod.POST})
    public String testMapping() {
        return "success";
    }*/

    //params属性数组中的多个参数需要同时携带
    @RequestMapping(value = "testParams", params = {"username", "password=123456"})
    public String testParams() {
        return "success";
    }

    //@RequestMapping(value = "/a？a/testAnt")
    //@RequestMapping(value = "/a*a/testAnt")
    //@RequestMapping(value = "/a**a/testAnt")//这样写不行
    @RequestMapping(value = "/a/**/a/testAnt")
    public String testAnt() {
        return "success";
    }

    @RequestMapping("/testPath/{id}/{username}/{password}")
    public String testPath(@PathVariable("id") Integer id, @PathVariable("username") String username, @PathVariable("password") String password) {
        System.out.println("id: " + id);
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        return "success";
    }
}
