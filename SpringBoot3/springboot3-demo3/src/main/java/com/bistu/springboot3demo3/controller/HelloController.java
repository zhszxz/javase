package com.bistu.springboot3demo3.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//或者使用Lombok的@Slf4j注解
@Slf4j
public class HelloController {
    //Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping("/h")
    public String hello() {
       // logger.info("hello方法执行了");
        log.info("hello方法执行了");
        return "hello!";
    }
}
