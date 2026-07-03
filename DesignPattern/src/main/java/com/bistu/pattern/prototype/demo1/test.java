package com.bistu.pattern.prototype.demo1;

//object类的clone方法底层没有调用构造方法
public class test {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyClass myClass = new MyClass();
        MyClass clone = myClass.clone();
        System.out.println("原型对象和克隆对象是同一个对象吗？" + (myClass == clone));
    }
}
