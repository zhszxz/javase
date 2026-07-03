package com.bistu.spring6iocxml.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testBookDi {
    @Test
    public void testSetter(){
        //依赖注入，setter方式
        ApplicationContext context=new ClassPathXmlApplicationContext("bean-di.xml");
        Object book = context.getBean("book");
        System.out.println(book);
    }

    @Test
    public void testconstructor(){
        //依赖注入，构造器方式
        ApplicationContext context=new ClassPathXmlApplicationContext("bean-di.xml");
        Object book = context.getBean("bookcon");
        System.out.println(book);
    }

}
