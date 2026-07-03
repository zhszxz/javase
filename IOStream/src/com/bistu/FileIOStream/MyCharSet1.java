package com.bistu.FileIOStream;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class MyCharSet1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
       /*
       Java中编码的方法
            public byte[] getBytes()                        使用默认方式进行编码
            public byte[] getBytes(String charsetName)      使用指定方式进行编码

        Java中解码的方法
            String(byte[] bytes)                            使用默认方式进行解码
            String(byte[] bytes, String charsetName)        使用指定方式进行解码
        */


        //1.编码
        String str = "Java中编码的方法";
        byte[] bytes = str.getBytes();//默认编码方式，idea为utf-8
        System.out.println(Arrays.toString(bytes));

        byte[] bytes1 = str.getBytes("GBK");//指定编码方式
        System.out.println(Arrays.toString(bytes1));

        //2.解码
        String str1 = new String(bytes);
        System.out.println(str1);

        String str2 = new String(bytes, "gbk");//编解码方式不一致，出现乱码
        System.out.println(str2);

        String str3 = new String(bytes1, "gbk");
        System.out.println(str3);
    }
}