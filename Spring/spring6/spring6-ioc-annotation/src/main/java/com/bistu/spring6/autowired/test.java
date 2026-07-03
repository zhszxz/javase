package com.bistu.spring6.autowired;

import com.bistu.spring6.autowired.controller.userController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        userController bean = context.getBean(userController.class);
        bean.addUserController();
    }
}
