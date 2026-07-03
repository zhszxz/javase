package com.bistu.pattern.template;

//模板方法模式
public class Client {
    public static void main(String[] args) {
        //炒包菜
        //创建对象
        ConcreteClass_BaoCai baoCai = new ConcreteClass_BaoCai();
        //调用炒菜的功能
        baoCai.cookProcess();
    }
}
