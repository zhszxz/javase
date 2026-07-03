package com.bistu.FileIOStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class MyFOS2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("FileOutputStream\\abc.txt");
        byte[] b=new byte[26];
        for (int i = 0; i < b.length; i++) {
            b[i]= (byte) (i+97);
        }
        fos.write(b);
        fos.close();
    }
}
