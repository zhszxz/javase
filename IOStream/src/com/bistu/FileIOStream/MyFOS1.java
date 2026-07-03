package com.bistu.FileIOStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class MyFOS1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("FileOutputStream\\abc.txt");
        fos.write(97);
        fos.write(98);
        fos.write(99);
        fos.close();
    }
}
