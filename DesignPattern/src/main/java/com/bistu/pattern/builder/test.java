package com.bistu.pattern.builder;

//建造者模式
public class test {
    public static void main(String[] args) {
        Computer computer = Computer.builder()
                .cpu("r5-5600")
                .memory("金百达16g")
                .hardDisk("铠侠rc20")
                .bulid();
        System.out.println(computer);
    }
}
