package com.bistu.ReflectParctice.practice1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IOException {
          /*
        对于任意一个对象，都可以把对象所有的字段名和值，保存到文件中去
    */
        Student s = new Student("小A", 23, '女', 167.5, "睡觉");
        Teacher t = new Teacher("播妞", 10000);
        saveObject(t);

    }

    private static void saveObject(Object obj) throws ClassNotFoundException, IllegalAccessException, IOException {
        //获取字节码文件对象
        Class clzz = Class.forName(obj.getClass().getName());
        //获取所有字段
        Field[] fielss = clzz.getDeclaredFields();
        //开流
        BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));
        //把所有字段写到文件
        for (Field field : fielss) {
            field.setAccessible(true);
            bw.write(field.getName() + "=" + field.get(obj));
            bw.newLine();
        }
        //关流
        bw.close();
    }
}
