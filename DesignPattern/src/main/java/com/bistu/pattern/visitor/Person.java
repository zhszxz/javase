package com.bistu.pattern.visitor;

public interface Person {
    void feed(Cat cat);

    void feed(Dog dog);
}
