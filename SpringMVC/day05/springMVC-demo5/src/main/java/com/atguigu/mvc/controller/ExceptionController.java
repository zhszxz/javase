package com.atguigu.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Date:2021/7/10
 * Author:ybc
 * Description:
 */
//组件实现异常处理
@ControllerAdvice
public class ExceptionController {
    //出现以下异常则执行这个控制器方法
    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
    public String testExecption(Exception exception, Model model) {
        model.addAttribute("ex",exception);
        return "error";
    }
}
