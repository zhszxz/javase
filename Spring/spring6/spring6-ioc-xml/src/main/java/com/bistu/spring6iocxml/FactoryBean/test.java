package com.bistu.spring6iocxml.FactoryBean;

import com.bistu.spring6iocxml.lifecycle.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-FactoryBean.xml");
        User user= (User)context.getBean("factoryBean");
        System.out.println(user);
    }
}
