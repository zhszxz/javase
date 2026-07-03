package com.bistu.ObjectStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MyObject2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("zhangsan.txt"));
        Student student = (Student) ois.readObject();
        System.out.println(student.toString());
    }
}
