package com.bistu.validator.one;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

public class testPerson {
    public static void main(String[] args) {
        person person = new person("zhangsan",79);
        DataBinder binder = new DataBinder(person);
        binder.setValidator(new PersonValidator());
        binder.validate();
        BindingResult bindingResult = binder.getBindingResult();
        System.out.println(bindingResult.getAllErrors());
    }
}
