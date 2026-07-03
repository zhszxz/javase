package com.bistu.pattern.proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//获取代理对象的工厂类
public class ProxyFactory {

    //目标对象
    private TrainStation trainStation = new TrainStation();

    //获取代理对象的方法
    public SellTickets getProxyObject() {
        //使用Proxy获取代理对象
        /*
            newProxyInstance()方法参数说明：
                ClassLoader loader ： 类加载器，用于加载代理类，使用目标对象的类加载器即可
                Class<?>[] interfaces ： 目标对象所实现的接口，代理模式目标对象和代理对象实现相同的接口
                InvocationHandler h ： 代理对象的调用处理程序
         */
        SellTickets proxyObject = (SellTickets) Proxy.newProxyInstance(
                trainStation.getClass().getClassLoader(),
                trainStation.getClass().getInterfaces(),
                new InvocationHandler() {
                    /*
                       InvocationHandler中invoke方法参数说明：
                           proxy ： 代理对象
                           method ： 对应于在代理对象上调用的接口方法的 Method 实例
                           args ： 代理对象调用接口方法时传递的实际参数
                    */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("（jdk动态代理）代售点收取手续费");
                        Object object = method.invoke(trainStation, args);
                        return object;
                    }
                }
        );
        return proxyObject;
    }
}
