package com.bistu.ZipStream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MyZipStream3 {


    public static void main(String[] args) throws IOException {
        /*
         *   压缩流
         *      需求：
         *          把文件夹里的 .md文件压缩成一个压缩包
         * */


        //1.创建File对象表示要压缩的文件夹
        File src = new File("D:\\Java\\Java基础-资料2");
        //2.创建File对象表示压缩包放在哪里（压缩包的父级路径）
        File destParent = src.getParentFile();//D:\Java\Java基础-资料2\day29-IO（其他流）\代码
        //3.创建File对象表示压缩包的路径
        File dest = new File(destParent, src.getName() + ".zip");
        //4.创建压缩流关联压缩包
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest));
        //5.获取src里面的每一个文件，变成ZipEntry对象，放入到压缩包当中
        toZip(src, zos, src.getName());//aaa
        //6.释放资源
        zos.close();
    }

    /*
     *   作用：获取src里面的每一个文件，变成ZipEntry对象，放入到压缩包当中
     *   参数一：数据源
     *   参数二：压缩流
     *   参数三：压缩包内部的路径
     * */
    private static void toZip(File src, ZipOutputStream zos, String name) throws IOException {
        File[] files = src.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                String[] split = file.getName().split("\\.");
                if(split.length>1&&"md".equals(split[1])){
                    ZipEntry Entry = new ZipEntry(name + "\\" + file.getName());
                    zos.putNextEntry(Entry);
                    //FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                    byte[] bytes = new byte[1024];
                    int len;
                    while ((len=bis.read(bytes))!=-1){
                        zos.write(bytes,0,len);
                    }
                    bis.close();
                    /*int b;
                    while ((b = fis.read()) != -1) {
                        zos.write(b);
                    }
                    fis.close();*/
                }
            } else {
                toZip(file, zos, name + "\\" + file.getName());
            }
        }


    }
}
