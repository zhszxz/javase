package com.bistu.spring6.bean;

import com.bistu.spring6.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        User bean = context.getBean(User.class);
        System.out.println(bean);
    }
}
