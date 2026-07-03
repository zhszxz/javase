package com.bistu.validator.two;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class testUser {
    @Test
    public void testValitadion1(){
        ApplicationContext context=new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation1 validation1 = context.getBean(MyValidation1.class);
        boolean mess = validation1.validator1(new User("lucy",34));
        System.out.println(mess);
    }

    @Test
    public void testValitadion2(){
        ApplicationContext context=new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation2 validation2 = context.getBean(MyValidation2.class);
        User user = new User();
        user.setName("lucy");
        user.setAge(1000);
        boolean mess = validation2.validator2(user);
        System.out.println(mess);
    }
}
