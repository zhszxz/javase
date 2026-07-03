package com.bistu.FileIOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class MyFIS2 {
    public static void main(String[] args) throws IOException {
        /*
         *   练习：
         *       文件拷贝
         *       把文件拷贝到当前模块下。
         *
         *   注意：
         *       选择一个比较小的文件，不要太大。大文件拷贝我们下一个视频会说。
         *
         *
         *
         *   课堂练习：
         *       要求统计一下拷贝时间，单位毫秒
         * */
        Date d1=new Date();
        long starttime = d1.getTime();


        FileInputStream fis=new FileInputStream("C:\\Users\\user\\Desktop\\新建 文本文档.txt");
        FileOutputStream fos=new FileOutputStream("copy.txt");


        int b=0;
        while((b=fis.read())!=-1){
            fos.write(b);
        }

        fos.close();;
        fis.close();

        Date d2=new Date();
        long endtime = d2.getTime();
        System.out.println(endtime-starttime);
    }
}
