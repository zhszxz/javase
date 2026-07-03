package com.bistu.test;

import java.io.*;

public class Mytest4 {


    public static void main(String[] args) throws IOException {
           /*
                四种方式拷贝文件，并统计各自用时
           */

        long start = System.currentTimeMillis();
        //method1();
        //method2();          //4833ms
        //method3();          //4823ms
        method4();            //882ms
        long end = System.currentTimeMillis();
        System.out.println((end - start) +"毫秒");


    }


    //字节流的基本流：一次读写一个字节4,588,568,576 字节
    public static void method1() throws IOException {
       FileInputStream fis=new FileInputStream("C:\\Users\\user\\Desktop\\Java核心技术·卷 I（原书第11版） (凯·S.霍斯特曼 (Cay S. Horstmann)) (Z-Library).pdf");
       FileOutputStream fos=new FileOutputStream("copy.pdf");

       int b;
       while ((b=fis.read())!=-1){
           fos.write(b);
       }
        fos.close();
        fis.close();
    }

    //字节流的基本流：一次读写一个字节数组
    public static void method2() throws IOException {
        FileInputStream fis=new FileInputStream("C:\\Users\\user\\Desktop\\Java核心技术·卷 I（原书第11版） (凯·S.霍斯特曼 (Cay S. Horstmann)) (Z-Library).pdf");
        FileOutputStream fos=new FileOutputStream("copy.pdf");

        byte[] bytes = new byte[1024];
        int len;
        while ((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        fos.close();
        fis.close();
    }

    //字节流的缓冲流：一次读写一个字节
    public static void method3() throws IOException {
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("C:\\Users\\user\\Desktop\\Java核心技术·卷 I（原书第11版） (凯·S.霍斯特曼 (Cay S. Horstmann)) (Z-Library).pdf"));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("copy.pdf"));

        int b;
        while ((b=bis.read())!=-1){
            bos.write(b);
        }
        bos.close();
        bis.close();
    }

    //字节流的缓冲流：一次读写一个字节数组
    public static void method4() throws IOException {
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("C:\\Users\\user\\Desktop\\Java核心技术·卷 I（原书第11版） (凯·S.霍斯特曼 (Cay S. Horstmann)) (Z-Library).pdf"));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("copy.pdf"));

        byte[] bytes = new byte[1024];
        int len;
        while ((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bos.close();
        bis.close();
    }
}
