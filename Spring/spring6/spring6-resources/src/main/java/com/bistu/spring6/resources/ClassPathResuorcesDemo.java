package com.bistu.spring6.resources;

import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClassPathResuorcesDemo {
    public static void main(String[] args) throws IOException {
        loadClassPathResource("a.txt");
    }

    public static void loadClassPathResource(String path) throws IOException {
        ClassPathResource resource = new ClassPathResource(path);
        System.out.println(resource.getFilename());
        System.out.println(resource.getDescription());

        InputStream inputStream = resource.getInputStream();
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) != -1) {
            System.out.println(new String(bytes));
        }
    }
}
