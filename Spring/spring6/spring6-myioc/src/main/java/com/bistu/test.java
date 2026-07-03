package com.bistu;

import com.bistu.Bean.AnnotationApplicationContext;
import com.bistu.Bean.ApplicationContext;
import com.bistu.service.UserService;

public class test {
    public static void main(String[] args) throws Exception {
        ApplicationContext context=new AnnotationApplicationContext("com.bistu");
        UserService bean = (UserService)context.getBean(UserService.class);
        bean.add();
    }
}
