package com.bistu.pattern.proxy.jdk_proxy;

//jdk动态代理
public class Client {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory();
        SellTickets proxyObject = factory.getProxyObject();
        proxyObject.sell();
    }
}
