package com.bistu.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * respone对象重定向
 * */
@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("resp1...");
//        //重定向
//        //设置响应状态码302，告诉浏览器要进行重定向
//        resp.setStatus(302);
//        //设置响应头，只是重定向资源的位置
//        resp.setHeader("Loaction","resp2");】

        //简化写法
        resp.sendRedirect("resp2");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
