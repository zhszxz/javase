package com.bistu.spring6.resourcesLoader;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class resourseLoaderDemo {
    @Test
    public void demo1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        Resource resource = context.getResource("a.txt");
        System.out.println(resource.getFilename());
    }

    @Test
    public void demo2(){
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext();
        Resource resource = context.getResource("a.txt");
        System.out.println(resource.getFilename());
    }
}
