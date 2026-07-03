package com.bistu.Thread3;

public class test {
    public static void main(String[] args) {
        Cook c=new Cook();
        Foodie f=new Foodie();

        c.setName("厨师");
        f.setName("吃货");

        c.start();
        f.start();
    }
}
