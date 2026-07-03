package com.bistu.spring6.resourse.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//配置类，代替配置文件
@Configuration
//开启组件扫描
@ComponentScan("com.bistu.spring6")
public class SpringConfig {
}
