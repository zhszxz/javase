package com.bistu.FileIOStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class MyFOS3 {
    public static void main(String[] args) throws IOException {
         /*
            换行写：
                再次写出一个换行符就可以了
                windows： \r\n
                Linux:    \n
                Mac:      \r

            续写：
                如果想要续写，打开续写开关即可
                开关位置：创建对象的第二个参数
                默认false：表示关闭续写，此时创建对象会清空文件
                手动传递true：表示打开续写，此时创建对象不会清空文件
        */
        FileOutputStream fos=new FileOutputStream("FileOutputStream\\abc.txt");
        String line1 = "zheshidiyihang";
        byte[] bytes1 = line1.getBytes();
        fos.write(bytes1);

        String s = "\t\n";
        byte[] bytes2 = s.getBytes();
        fos.write(bytes2);

        String line2 = "zheshidierhang";
        byte[] bytes3 = line2.getBytes();
        fos.write(bytes3);

        fos.close();



        FileOutputStream fos2=new FileOutputStream("FileOutputStream\\abc.txt",true);
        String xuxie = "xuxiechenggonglema";
        byte[] bytes4 = xuxie.getBytes();
        fos2.write(bytes4);

        fos2.close();
    }
}
