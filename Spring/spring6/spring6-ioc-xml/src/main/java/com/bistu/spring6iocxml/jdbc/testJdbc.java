package com.bistu.spring6iocxml.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testJdbc {
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("bean-jdbc.xml");
        DruidDataSource druidDataSource = (DruidDataSource)context.getBean("druidDataSource");
        System.out.println(druidDataSource.getUrl());
    }
}
