package com.bistu.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class ContextLoadListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //application被创建时执行
        System.out.println("application被创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //被销毁时执行
    }
}
