package com.bistu.spring6iocxml.di;

import com.bistu.spring6iocxml.di.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testMap {
    @Test
    public void testMap(){
        ApplicationContext context=new ClassPathXmlApplicationContext("bean-di-map.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student.toString());
    }
}
