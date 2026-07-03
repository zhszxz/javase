package com.bistu.spring6.resourse;

import com.bistu.spring6.resourse.config.SpringConfig;
import com.bistu.spring6.resourse.controller.userController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        //ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        userController bean = context.getBean("myUserController",userController.class);
        bean.addUserController();
    }
}
