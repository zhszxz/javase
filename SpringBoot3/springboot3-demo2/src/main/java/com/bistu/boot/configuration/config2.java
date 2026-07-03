package com.bistu.boot.configuration;

//import com.alibaba.druid.FastsqlException;

import com.bistu.boot.pojo.*;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootConfiguration
/*场景：SpringBoot默认只扫描自己主程序所在的包。如果导入第三方包，
即使组件上标注了 @Component、@ConfigurationProperties 注解也没用。
因为组件都扫描不进来，此时使用这个注解就可以快速进行属性绑定并把组件注册进容器*/
@EnableConfigurationProperties(sheep.class)
public class config2 {
    @Bean
    @ConfigurationProperties(prefix = "pig")
    public pig pig1() {
        return new pig();
    }

    @Bean
    //条件注解，若容器中有指定的类，则放一个cat
    @ConditionalOnClass(name = "com.alibaba.druid.FastsqlException")
    public Cat cat1() {
        return new Cat();
    }

    @Bean
    //条件注解，若容器中没有指定的类，则放一个dog
    @ConditionalOnMissingClass(value = "com.alibaba.druid.FastsqlException")
    public Dog dog1() {
        return new Dog();
    }

    @Bean
    //条件注解，若容器中有指定的组件，则放一个user组件，名叫zhangsan
    @ConditionalOnBean(value = Dog.class)
    public user zhagsan() {
        return new user();
    }

    @Bean
    //条件注解，若容器中没有指定的组件，则放一个user组件，名叫lisi
    @ConditionalOnMissingBean(value = Dog.class)
    public user lisi() {
        return new user();
    }
}
