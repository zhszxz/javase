package com.bistu.pattern.decorator;

/**
 * @version v1.0
 * @ClassName: Garnish
 * @Description: 装饰者类(抽象装饰者角色)，继承并聚合抽象构件角色
 * @Author: 黑马程序员
 */
public abstract class Garnish extends FastFood {

    private FastFood fastFood;

    public Garnish(FastFood fastFood, float price, String desc) {
        super(price, desc);
        this.fastFood = fastFood;
    }

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }
}
