package com.bistu.ConvertStream;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class MyConvertStream1 {

    public static void main(String[] args) throws IOException {
        /*
            利用转换流按照指定字符编码读取(了解)

            因为JDK11：这种方式被淘汰了。替代方案(掌握)

        */
        /*InputStreamReader isr = new InputStreamReader(new FileInputStream("test.txt"), "GBK");

        int b;
        while ((b = isr.read()) != -1) {
            System.out.print((char) b);
        }

        isr.close();*/


        //替代方案
        FileReader fr=new FileReader("test.txt",Charset.forName("GBK"));
        int b;
        while ((b = fr.read()) != -1) {
            System.out.print((char) b);
        }

        fr.close();
    }

}
