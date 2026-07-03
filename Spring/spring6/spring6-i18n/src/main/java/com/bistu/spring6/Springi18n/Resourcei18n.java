package com.bistu.spring6.Springi18n;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Resourcei18n {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Object[] objs = new Object[]{"bistu",new Date().toString()};
        String message = context.getMessage("www.bistu.com", objs, Locale.CHINA);
        System.out.println(message);
    }
}
