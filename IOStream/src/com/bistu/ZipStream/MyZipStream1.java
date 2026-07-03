package com.bistu.ZipStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class MyZipStream1 {
    public static void main(String[] args) throws IOException {
        /*
         *   解压缩流
         *
         * */
        File src=new File("C:\\Users\\user\\Desktop\\myio.zip");
        File dest=new File("E:\\myio");
        unzip(src,dest);
    }

        public static void unzip (File src, File dest) throws IOException {
            ZipInputStream zip = new ZipInputStream(new FileInputStream(src));

            ZipEntry nextEntry;

            while ((nextEntry = zip.getNextEntry()) != null) {
                if (nextEntry.isDirectory()){
                    File dir=new File(dest,nextEntry.toString());
                    dir.mkdirs();
                }else{
                    File file=new File(dest,nextEntry.toString());
                    FileOutputStream fos=new FileOutputStream(file);
                    int b;

                    while((b=zip.read())!=-1){
                        fos.write(b);
                    }
                    fos.close();
                    zip.closeEntry();
                }
            }
            zip.close();
        }

}
