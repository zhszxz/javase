package com.bistu.spring6.resources;

import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.InputStream;

public class FileSystemResourcesDemo {
    public static void main(String[] args) throws IOException {
        loadFileSystemResource("C:\\END");
    }

    public static void loadFileSystemResource(String path) throws IOException {
        FileSystemResource resource = new FileSystemResource(path);
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());

        InputStream inputStream = resource.getInputStream();
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes)!=-1){
            System.out.println(new String(bytes));
        }
    }
}
