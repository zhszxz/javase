package com.bistu.web;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
/*
* xml配置servlet
*/
public class ServletDemo6 extends MyHttpServlet {
    @Override
    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {

    }

    @Override
    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println(("demo 6 get...."));
    }
}