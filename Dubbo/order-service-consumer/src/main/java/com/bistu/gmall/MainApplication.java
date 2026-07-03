package com.bistu.gmall;

import com.bistu.gmall.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");
        OrderService bean = ioc.getBean(OrderService.class);
        bean.initOrder("1");
        System.in.read();
    }
}
