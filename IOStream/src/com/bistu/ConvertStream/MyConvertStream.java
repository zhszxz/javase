package com.bistu.ConvertStream;

import java.io.*;
import java.nio.charset.Charset;

public class MyConvertStream {
    public static void main(String[] args) throws IOException {
           /*
            将本地文件中的GBK文件，转成UTF-8
        */
        //jdk11以前的方式
        /*InputStreamReader isr=new InputStreamReader(new FileInputStream("d.txt"),"GBK");
        OutputStreamWriter osr=new OutputStreamWriter(new FileOutputStream("e.txt"),"UTF-8");

        int b;
        while((b=isr.read())!=-1){
            osr.write(b);
        }

        osr.close();
        isr.close();*/

        //替代方案
        FileReader fr=new FileReader("d.txt", Charset.forName("gbk"));
        FileWriter fw=new FileWriter("e.txt",Charset.forName("utf-8"));
         int b;
         while((b= fr.read())!=-1){
             fw.write(b);
         }

        fw.close();
        fr.close();

    }
}
