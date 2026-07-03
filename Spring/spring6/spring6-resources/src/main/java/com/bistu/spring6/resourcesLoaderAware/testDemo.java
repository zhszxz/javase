package com.bistu.spring6.resourcesLoaderAware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

public class testDemo {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");
        TestBean bean = context.getBean(TestBean.class);
        ResourceLoader resourceLoader = bean.getResourceLoader();
        System.out.println(context==resourceLoader);
    }
}
