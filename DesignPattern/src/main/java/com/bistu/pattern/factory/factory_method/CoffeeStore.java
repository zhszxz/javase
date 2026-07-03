package com.bistu.pattern.factory.factory_method;

/**
 * @version v1.0
 * @ClassName: CoffeeStore
 * @Description: TODO(一句话描述该类的功能)
 * @Author: 黑马程序员
 */
public class CoffeeStore {

    private CoffeeFactory factory;

    public CoffeeStore(CoffeeFactory factory) {
        this.factory = factory;
    }

    public Coffee orderCoffee() {
        Coffee coffee = factory.createCoffee();
        //加配料
        coffee.addMilk();
        coffee.addsugar();
        return coffee;
    }
}
