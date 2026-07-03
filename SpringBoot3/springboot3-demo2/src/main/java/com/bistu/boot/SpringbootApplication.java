package com.bistu.boot;

import com.bistu.boot.pojo.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ioc = SpringApplication.run(SpringbootApplication.class, args);
        /*String[] definitionNames = ioc.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println(definitionName);
        }
        user user1 = ioc.getBean(user.class);
        user user2 = ioc.getBean(user.class);
        System.out.println(user1==user2);*/
       /* String[] cat = ioc.getBeanNamesForType(cat.class);
        System.out.println("cat:" + Arrays.toString(cat));
        String[] dog = ioc.getBeanNamesForType(dog.class);
        System.out.println("dog:" + Arrays.toString(dog));*/
       /* String[] namesForType = ioc.getBeanNamesForType(user.class);
        for (String s : namesForType) {
            System.out.println("user:"+s);
        }*/

      /*  pig pig = ioc.getBean(pig.class);
        System.out.println(pig);
        sheep sheep = ioc.getBean(sheep.class);
        System.out.println(sheep);*/

        Person person = ioc.getBean(Person.class);
        System.out.println(person);
    }
}
