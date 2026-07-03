package com.bistu.spring6.aop.annoAop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testAop {
    @Test
    public void add(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        Calculator bean = context.getBean(Calculator.class);
        System.out.println(bean.add(5, 6));
    }
}
