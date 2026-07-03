package com.bistu.spring6;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class testUserObject {
    private Logger logger= LoggerFactory.getLogger(testUserObject.class);
    @Test
    public void testUser() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User) ac.getBean("user");
        System.out.println("1." + user);
        System.out.print("2.");
        user.add();

        logger.info("### 手动写日志。。。。");
    }

    @Test
    public void fanshe() throws Exception {
        Class<?> clzz = Class.forName("com.bistu.spring6.User");
        User user = (User) clzz.getDeclaredConstructor().newInstance();
        user.add();
    }
}

