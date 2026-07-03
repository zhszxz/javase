package com.bistu.spring6.aop.example;

public class testCal {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        //获取代理类对象
        Calculator proxy = (Calculator)proxyFactory.getProxy();
        proxy.add(1, 2);
        proxy.sub(6,24);
        proxy.mul(5,7);
        proxy.div(88,4);

    }
}
