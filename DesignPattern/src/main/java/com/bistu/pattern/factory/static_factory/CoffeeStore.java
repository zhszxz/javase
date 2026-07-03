package com.bistu.pattern.factory.static_factory;


public class CoffeeStore {

    public Coffee orderCoffee(String type) {

        Coffee coffee = StaticCoffeeFactory.createCoffee(type);
        //加配料
        coffee.addMilk();
        coffee.addsugar();

        return coffee;
    }
}
