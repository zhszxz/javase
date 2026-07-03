package com.bistu.spring6iocxml.bean;

import com.bistu.spring6iocxml.bean.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testUserDao {
    public static void main(String[] args) {
        //验证能否通过接口类型获取对应实现类的bean
        //ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //可以通过接口字节码文件获取对应实现类的bean
       // UserDao bean = context.getBean(UserDao.class);
       // bean.run();

        //验证配置了一个接口多个实现类的bean，能否通过接口类型获取对应实现类的bean
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        UserDao bean = context.getBean(UserDao.class);
        bean.run();
        //结论：不行，因为接口对应了多个bean
        // No qualifying bean of type 'com.bistu.spring6iocxml.bean.UserDao' available:
        // expected single matching bean but found 2: userdaoimpl,userdaoimpl2
    }
}
