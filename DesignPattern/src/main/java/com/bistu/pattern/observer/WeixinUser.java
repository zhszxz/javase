package com.bistu.pattern.observer;

/**
 * 具体观察者角色
 */
public class WeixinUser implements Observer {

    private String name;

    public WeixinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println("用户: " + name + " 收到了新消息推送-" + msg);
    }
}
