package com.bistu.pattern.factory.static_factory;

//静态工厂模式
public class StaticCoffeeFactory {

    public static Coffee createCoffee(String type) {
        Coffee coffee = null;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("对不起，您所点的咖啡没有");
        }
        return coffee;
    }
}
