package com.bistu.ReflectParctice.practice2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class test {
    /*
       反射可以跟配置文件结合的方式，动态的创建对象，并调用方法
   */
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //读取配置文件
        Properties prop = new Properties();
        prop.load(new FileReader("prop.properties"));
        String classname = (String) prop.get("classname");
        String methodname = (String) prop.get("method");
        System.out.println(classname);
        //获取构造方法
        Class clzz = Class.forName(classname);
        Constructor con = clzz.getDeclaredConstructor();
        con.setAccessible(true);
        //创建对象
        Object o = con.newInstance();
        System.out.println(o);
        //获取成员方法
        Method method = clzz.getDeclaredMethod(methodname);
        method.invoke(o);
    }


}
