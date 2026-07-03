package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseSevlet extends HttpServlet {
    //重写service方法，根据请求的路径分发到相应方法
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求路径中的方法名
        String requestURI = req.getRequestURI();
        int index = requestURI.lastIndexOf('/');
        String methodName = requestURI.substring(index + 1);
        System.out.println(methodName);

        Class<? extends BaseSevlet> Cls = this.getClass();
        try {
            //利用反射获取指定方法并执行
            Method method = Cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

