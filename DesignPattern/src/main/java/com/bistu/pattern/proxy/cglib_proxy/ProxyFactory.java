package com.bistu.pattern.proxy.cglib_proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {

    private TrainStation trainStation = new TrainStation();

    //获取代理类，代理类是目标类的子类
    public TrainStation getProxyObject() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(trainStation.getClass());
        //设置回调函数：参数是MethodInterceptor接口实现类对象
        enhancer.setCallback(this);
        TrainStation proxyObject = (TrainStation) enhancer.create();
        return proxyObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib动态代理：收取手续费");
        Object object = method.invoke(trainStation, objects);
        return object;
    }
}
