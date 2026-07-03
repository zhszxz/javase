package com.bistu.ConvertStream;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class MyConvertStream2 {
    public static void main(String[] args) throws IOException {
        /*
            利用转换流按照指定字符编码写出
        */


      //利用转换输出流
       /* OutputStreamWriter osr=new OutputStreamWriter(new FileOutputStream("d.txt"),"GBK");
        osr.write("嗯哼哼啊啊啊啊啊");
        osr.close();*/

        FileWriter fw = new FileWriter("d.txt", Charset.forName("GBK"));
        fw.write("你好你好");
        fw.close();


    }


}
