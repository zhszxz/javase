package com.bistu.boot.configuration;

import com.bistu.boot.pojo.user;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootConfiguration
public class config {

    @Bean
    @Scope("prototype")//多实例
    public user user1() {
        user user = new user();
        user.setId(1l);
        user.setName("张三");
        return user;
    }
}
