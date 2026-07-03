package com.bistu.validator.two;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan("com.bistu.validator.two")
public class ValidationConfig {
    @Bean
    public LocalValidatorFactoryBean getValidatorFactoryBean(){
        return new LocalValidatorFactoryBean();
    }
}
