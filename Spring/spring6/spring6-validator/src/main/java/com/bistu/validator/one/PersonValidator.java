package com.bistu.validator.one;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //name不能为空
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty", "name can't be null");
        //年龄不能超出范围
        person person = (person) target;
        if (person.getAge() < 0) {
            errors.rejectValue("age", "age.value.small", "age<0");
        }
        if (person.getAge() > 200) {
            errors.rejectValue("age", "age.value.huge", "age>200");
        }
    }
}
