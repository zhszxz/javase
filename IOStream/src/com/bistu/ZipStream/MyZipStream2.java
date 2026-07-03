package com.bistu.ZipStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MyZipStream2 {
    public static void main(String[] args) throws IOException {
        File src=new File("D:\\Java\\Java基础-资料2\\day29-IO（其他流）\\代码\\myio\\a.txt");
        File dest=new File("E:\\");
        tozip(src,dest);
    }

    private static void tozip(File src, File dest) throws IOException {
        ZipOutputStream zip=new ZipOutputStream(new FileOutputStream(new File(dest,"a.zip")));
        ZipEntry entry = new ZipEntry("a.txt");
        //3.把ZipEntry对象放到压缩包当中
        zip.putNextEntry(entry);

        FileInputStream fis=new FileInputStream(src);
        int b;
        while((b=fis.read())!=-1){
            zip.write(b);
        }
        fis.close();
        zip.closeEntry();
        zip.close();
    }
}
