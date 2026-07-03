package com.bistu.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * respone响应字符数据：设置字符数据响应体
 * */
@WebServlet("/resp3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //简化写法：同时设置响应头和流的编码方式
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        //设置响应头，告诉浏览器写的是html
        //resp.setHeader("content-type","text/html");
        writer.write("谁他妈学计算机呀");
        writer.write("<h1>hello response!</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
