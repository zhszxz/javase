package com.bistu.spring6iocxml.lifecycle;

public class User {
    private String name;


    public User() {
        System.out.println("1.无参构造");
    }

    public User(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
        System.out.println("2.设置属性");
    }

    public void init(){
        System.out.println("4.初始化方法");
    }

    public void destroy(){
        System.out.println("7.销毁方法");
    }

    public String toString() {
        return "User{name = " + name + "}";
    }
}
