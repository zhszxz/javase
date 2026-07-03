package com.bistu.test;

import java.io.*;

public class Mytest1{
    public static void main(String[] args) throws IOException {
        File f1=new File("D:\\Java\\Java基础-资料2\\day28-IO（字节流&字符流）\\代码\\myio");
        File f2=new File("copy");
        //拷贝一个文件夹，考虑子文件夹
        copy(f1,f2);
    }

    private static void copy(File src,File dest) throws IOException {
        dest.mkdirs();
        File[] files = src.listFiles();
        for (File file : files) {
            if(file.isFile()) {
                FileInputStream fis=new FileInputStream(file);
                FileOutputStream fos=new FileOutputStream(new File(dest,file.getName()));
                byte[] bytes = new byte[1024];
                int len;
                while((len=fis.read(bytes))!=-1){
                    fos.write(bytes,0,len);
                }
                fos.close();
                fis.close();
            }
            else{
                copy(file,new File(dest,file.getName()));
            }

        }
    }
}
