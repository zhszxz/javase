package com.bistu.web;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
/*
* urlPatterns是一个String[]，可以配置多个路径，通过这些路径都能访问servlet
*/
@WebServlet(urlPatterns = {"/demo5","/demo-5"})
public class ServletDemo5 extends MyHttpServlet {
    @Override
    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {

    }

    @Override
    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println(("demo 5 get...."));
    }
}