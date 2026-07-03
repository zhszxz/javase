package com.bistu.spring6iocxml.scope;

import com.bistu.spring6iocxml.scope.orders;
import org.junit.jupiter.api.Order;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrders {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-scope.xml");
        orders o1 = context.getBean("orders", orders.class);
        orders o2 = context.getBean("orders", orders.class);
        //两次获取是同一个对象吗？
        System.out.println(o1);
        System.out.println(o2);
    }
}
