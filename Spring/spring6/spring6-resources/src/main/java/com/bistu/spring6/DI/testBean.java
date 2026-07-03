package com.bistu.spring6.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testBean {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        ResourceBean bean = context.getBean(ResourceBean.class);
        bean.parse();
    }
}
