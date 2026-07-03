package com.bistu.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Mytest2 {
    public static void main(String[] args) throws IOException {
         /*
            为了保证文件的安全性，就需要对原始文件进行加密存储，再使用的时候再对其进行解密处理。
            加密原理：
                对原始文件中的每一个字节数据进行更改，然后将更改以后的数据存储到新的文件中。
            解密原理：
                读取加密之后的文件，按照加密的规则反向操作，变成原始文件。
          */

        //加密
        /*File sourse=new File("C:\\Users\\user\\Pictures\\Screenshots\\屏幕截图 2024-03-16 212224.png");
        File target=new File("jiami.png");

        FileInputStream fis=new FileInputStream(sourse);
        FileOutputStream fos=new FileOutputStream("jiami.png");
        int b;
        while((b=fis.read())!=-1){
            fos.write(b^10);
        }
        fos.close();
        fis.close();*/

        //解密
        File sourse=new File("jiami.png");
        File result=new File("jiemi.png");

        FileInputStream fis=new FileInputStream(sourse);
        FileOutputStream fos=new FileOutputStream(result);

        int b;
        while ((b=fis.read())!=-1){
            fos.write(b^10);
        }
        fos.close();
        fis.close();
    }
}
