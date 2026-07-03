package com.bistu.spring6.preflx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class testDemo {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("url:bean.xml");
        Resource resource = context.getResource("a.txt");
        System.out.println(resource.getDescription());

    }
}