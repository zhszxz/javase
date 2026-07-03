package com.bistu.Reflect3;

import java.lang.reflect.Field;
import java.util.Arrays;

public class MyReflect3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
         /*
       Class类中用于获取成员变量的方法
            Field[] getFields()：                返回所有公共成员变量对象的数组
            Field[] getDeclaredFields()：        返回所有成员变量对象的数组
            Field getField(String name)：        返回单个公共成员变量对象
            Field getDeclaredField(String name)：返回单个成员变量对象

       Field类中用于创建对象的方法
            void set(Object obj, Object value)：赋值
            Object get(Object obj)              获取值

    */
        Class clzz = Class.forName("com.bistu.Reflect3.Student");

        Field[] fields = clzz.getFields();
        //System.out.println(Arrays.toString(fields));

        Field[] declaredFields = clzz.getDeclaredFields();
        //System.out.println(Arrays.toString(declaredFields));

        Field name = clzz.getDeclaredField("name");
        //System.out.println(name);

        int modifiers = name.getModifiers();
        System.out.println(modifiers);

        System.out.println(name.getType());

        System.out.println(name.getName());

        Student s = new Student("zhangsan", 23, "男");
        name.setAccessible(true);
        System.out.println(name.get(s));

        name.set(s, "lisi");

        System.out.println(s);
    }
}
