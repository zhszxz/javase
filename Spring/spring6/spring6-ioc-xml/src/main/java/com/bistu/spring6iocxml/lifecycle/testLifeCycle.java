package com.bistu.spring6iocxml.lifecycle;

import com.bistu.spring6iocxml.lifecycle.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testLifeCycle {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("bean-life.xml");
        User user = context.getBean("user", User.class);
        System.out.println("6.对象创建成功，可以使用了");
        context.close();
    }
}
