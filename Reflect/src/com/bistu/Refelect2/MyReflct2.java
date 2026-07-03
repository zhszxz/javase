package com.bistu.Refelect2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class MyReflct2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
         /*
        Class类中用于获取构造方法的方法
            Constructor<?>[] getConstructors()                                返回所有公共构造方法对象的数组
            Constructor<?>[] getDeclaredConstructors()                        返回所有构造方法对象的数组
            Constructor<T> getConstructor(Class<?>... parameterTypes)         返回单个公共构造方法对象
            Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) 返回单个构造方法对象


        Constructor类中用于创建对象的方法
            T newInstance(Object... initargs)                                 根据指定的构造方法创建对象
            setAccessible(boolean flag)                                       设置为true,表示取消访问检查
    */
        Class clzz = Class.forName("com.bistu.Refelect2.Student");
        //获取所有公有构造方法
        Constructor[] cons1 = clzz.getConstructors();
        //System.out.println(Arrays.toString(cons1));

        //获取所有构造方法
        Constructor[] cons2 = clzz.getDeclaredConstructors();
        //System.out.println(Arrays.toString(cons2));

        //获取单个公有构造方法
        //Constructor con1 = clzz.getConstructor();
        Constructor con1 = clzz.getConstructor(String.class);
        //System.out.println(con1);

        //返回单个构造方法对象
        Constructor con2 = clzz.getDeclaredConstructor(String.class,int.class);
        //System.out.println(con2);

        //利用获取的构造方法创建对象
        con2.setAccessible(true);
        Student stu = (Student)con2.newInstance("zhangsan", 23);
        System.out.println(stu);
    }
}
