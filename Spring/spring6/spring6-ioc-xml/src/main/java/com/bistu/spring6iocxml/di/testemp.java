package com.bistu.spring6iocxml.di;

import com.bistu.spring6iocxml.di.dept;
import com.bistu.spring6iocxml.di.emp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testemp {
    public static void main(String[] args) {
//        ApplicationContext context=new ClassPathXmlApplicationContext("bean-di-test.xml");
//        emp bean = (emp)context.getBean("emp");
//        bean.work();
//
//        emp emp2 = (emp)context.getBean("emp2");
//        emp2.work();

//        ApplicationContext context1 = new ClassPathXmlApplicationContext("bean-di-array.xml");
//        emp emp = (emp) context1.getBean("emp");
//        emp.work();

        ApplicationContext context2 = new ClassPathXmlApplicationContext("bean-di-list.xml");
        dept dept = (dept) context2.getBean("dept");
        System.out.println(dept.getEmpList());
    }
}
