package com.bistu.spring6iocxml.auto;

import com.bistu.spring6iocxml.auto.control.control;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-auto.xml");
        control control = context.getBean("control", control.class);
        control.addUser();
    }
}
