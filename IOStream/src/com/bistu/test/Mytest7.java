package com.bistu.test;

import java.io.*;
import java.util.ArrayList;

public class Mytest7 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*需求：
            将多个自定义对象序列化到文件中，但是对象的个数不确定，该如何操作呢？
        */
        Student s1=new Student("zhangsan",23,"南京");
        Student s2=new Student("lisi",24,"广州");
        Student s3=new Student("王五",25,"深圳");

        // 先将所有对象添加到集合中
        ArrayList<Student> list=new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        //再把集合序列化
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Students.txt"));
        oos.writeObject(list);
        oos.close();

        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Students.txt"));
        ArrayList<Student> list2 = (ArrayList<Student>)ois.readObject();

        System.out.println(list2);
    }
}
