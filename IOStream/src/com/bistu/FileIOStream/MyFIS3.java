package com.bistu.FileIOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFIS3 {
    public static void main(String[] args) throws IOException {
        /*
         *   练习：
         *       文件拷贝
         *       把Desktop\4.STM32参考资料\STM32F4xx中文参考手册.pdf"拷贝到当前模块下。
         *
         * */
        FileInputStream fis=new FileInputStream("C:\\Users\\user\\Desktop\\4.STM32参考资料\\STM32F4xx中文参考手册.pdf");
        FileOutputStream fos=new FileOutputStream("copy.pdf");

        byte[] arr=new byte[1024*1024*5];
        int len;

        long start = System.currentTimeMillis();

        while ((len=fis.read(arr))!=-1){
            fos.write(arr,0,len);
        }

        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }
}
