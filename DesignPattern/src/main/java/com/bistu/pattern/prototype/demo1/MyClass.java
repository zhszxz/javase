package com.bistu.pattern.prototype.demo1;

//原型模式：根据已有原型对象克隆新对象
public class MyClass implements Cloneable {
    public MyClass() {
        System.out.println("构造方法被调用了！");
    }

    @Override
    protected MyClass clone() throws CloneNotSupportedException {
        return (MyClass) super.clone();
    }
}
