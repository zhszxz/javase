package com.bistu.spring6iocxml.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testdiref {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean-di-ref.xml");
        Object student = context.getBean("student");
        System.out.println(student.toString());
    }
}
