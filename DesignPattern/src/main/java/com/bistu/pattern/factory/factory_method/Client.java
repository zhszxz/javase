package com.bistu.pattern.factory.factory_method;

public class Client {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore(new AmericanCoffeeFactory());
        Coffee coffee = coffeeStore.orderCoffee();
        System.out.println(coffee.getName());
    }
}
