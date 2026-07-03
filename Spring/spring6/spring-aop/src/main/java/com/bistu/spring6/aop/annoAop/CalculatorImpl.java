package com.bistu.spring6.aop.annoAop;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int result=i+j;
        System.out.println("方法内result="+result);
        //int a=10/0;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        return i-j;
    }

    @Override
    public int mul(int i, int j) {
        return i*j;
    }

    @Override
    public int div(int i, int j) {
        return i/j;
    }
}
