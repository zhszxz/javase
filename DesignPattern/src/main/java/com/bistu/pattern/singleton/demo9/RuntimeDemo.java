package com.bistu.pattern.singleton.demo9;

import java.io.IOException;
import java.io.InputStream;

//单例模式在jdk源码中的应用：Runtime
public class RuntimeDemo {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("ipconfig");
        InputStream is = process.getInputStream();
        byte[] bytes = new byte[1024 * 1024 * 100];
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len, "gbk"));
    }

}
