package com.bistu.spring6.resources;

import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;

//访问网络资源
public class UrlResourcesDemo {
    public static void main(String[] args) throws Exception {
        //loadUrlResouece("https://www.baidu.com");
        loadUrlResouece("file:a.txt");
    }
    public static void loadUrlResouece(String path) throws Exception {
        UrlResource resource = new UrlResource(path);
        System.out.println(resource.getFilename());
        System.out.println(resource.getURL());
        System.out.println(resource.getDescription());
      //  System.out.println(resource.getInputStream().read());
    }
}
