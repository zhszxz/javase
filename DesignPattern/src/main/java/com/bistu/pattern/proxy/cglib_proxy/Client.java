package com.bistu.pattern.proxy.cglib_proxy;

//cglib动态代理
public class Client {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory();
        TrainStation proxyObject = factory.getProxyObject();
        proxyObject.sell();
    }
}
