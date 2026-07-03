package com.bistu.FileIOStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class MyFIS1 {
    public static void main(String[] args) throws IOException {
        /*
         * 演示：字节输入流FileInputStream
         * 实现需求：读取文件中的数据。（暂时不写中文）
         *
         * 实现步骤：
         *       创建对象
         *       读取数据
         *       释放资源
         * */

        FileInputStream fis = new FileInputStream("FileInputStream\\a.txt");
        int read;
        while (true){
            read = fis.read();
            if(read==-1){
                break;
            }
            System.out.println((char) read);
        }
    }
}
