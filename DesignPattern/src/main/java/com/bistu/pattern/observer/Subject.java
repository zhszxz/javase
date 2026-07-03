package com.bistu.pattern.observer;

//抽象主题角色
public interface Subject {
void attach(Observer observer);
void detach(Observer observer);
void notify(String msg);
}
