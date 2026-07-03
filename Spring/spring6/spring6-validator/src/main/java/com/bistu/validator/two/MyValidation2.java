package com.bistu.validator.two;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.Validator;

@Component
public class MyValidation2 {
    @Autowired
    private Validator validator;
    public boolean validator2(User user){
        BindException exception = new BindException(user, user.getName());
        validator.validate(user,exception);
        System.out.println(exception.getAllErrors());
        return exception.hasErrors();
    }
}
