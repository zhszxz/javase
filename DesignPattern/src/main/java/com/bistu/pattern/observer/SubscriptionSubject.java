package com.bistu.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题角色
 */
public class SubscriptionSubject implements Subject {

    private List<Observer> weixinUserList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        weixinUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weixinUserList.remove(observer);
    }

    @Override
    public void notify(String msg) {
        for (Observer observer : weixinUserList) {
            observer.update(msg);
        }
    }
}
