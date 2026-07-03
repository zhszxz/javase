package com.bistu.spring6.junit.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:bean.xml")
public class testJunit {
    @Autowired
    private User user;
   @Test
    public void testUser(){
       System.out.println(user);
       user.run();
   }
}
