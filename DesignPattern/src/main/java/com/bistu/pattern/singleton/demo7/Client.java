package com.bistu.pattern.singleton.demo7;

import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {
        writeObject();
        Singleton instance1 = readObject();
        Singleton instance2 = readObject();
        System.out.println(instance1 == instance2);
    }

    public static void writeObject() throws Exception {
        Singleton instance = Singleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\user\\Desktop\\instance.txt"));
        oos.writeObject(instance);
        oos.close();
    }

    public static Singleton readObject() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\user\\Desktop\\instance.txt"));
        Singleton instance = (Singleton) ois.readObject();
        System.out.println(instance);
        ois.close();
        return instance;
    }
}
