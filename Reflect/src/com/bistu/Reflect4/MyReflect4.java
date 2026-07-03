package com.bistu.Reflect4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyReflect4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
         /*
       Class类中用于获取成员方法的方法
            Method[] getMethods()：返回所有公共成员方法对象的数组，包括继承的
            Method[] getDeclaredMethods()：返回所有成员方法对象的数组，不包括继承的
            Method getMethod(String name, Class<?>... parameterTypes) ：返回单个公共成员方法对象
            Method getDeclaredMethod(String name, Class<?>... parameterTypes)：返回单个成员方法对象


       Method类中用于创建对象的方法
            Object invoke(Object obj, Object... args)：运行方法
            参数一：用obj对象调用该方法
            参数二：调用方法的传递的参数（如果没有就不写）
            返回值：方法的返回值（如果没有就不写）

        获取方法的修饰符
        获取方法的名字
        获取方法的形参
        获取方法的返回值
        获取方法的抛出的异常

    */
        Class clzz = Class.forName("com.bistu.Reflect4.Student");

        //获取所有public方法，包括继承的
        Method[] methods = clzz.getMethods();
        for (Method method : methods) {
          //  System.out.println(method);
        }
        //获取所有方法，包括私有，不包括继承
        Method[] methods2 = clzz.getDeclaredMethods();
        for (Method method : methods2) {
           // System.out.println(method);
        }

        //获取单个成员方法,不能获取私有
        Method method = clzz.getMethod("sleep");
        //System.out.println(method);
        //Method method2 = clzz.getMethod("eat", String.class);

        //获取单个成元方法，包括私有
        Method eat = clzz.getDeclaredMethod("eat", String.class);
        //System.out.println(eat);

        eat.setAccessible(true);
        eat.invoke(new Student(),"汉堡");
        /*获取方法的修饰符
                获取方法的名字
        获取方法的形参
                获取方法的返回值
        获取方法的抛出的异常*/
        System.out.println(eat.getModifiers());
        System.out.println(eat.getName());
        System.out.println(Arrays.toString(eat.getParameters()));
        System.out.println(eat.getReturnType());
        System.out.println(Arrays.toString(eat.getExceptionTypes()));

    }
}
