package com.bistu.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

//中文乱码问题
@WebServlet("/req3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //get方式：获取参数方式getQueryString(),而非字符流，不能通过设置流的字符集解决
        // 乱码原因：浏览器会把请求中的中文编码后的二进制数再进行url编码，在tomcat服务器进行解码
        //url编码：以浏览器使用utf-8为例，”张三“编码后为6字节48比特，url编码把二进制数以字节为单位转为16进制，并在每字节前前面加上%
        //由于tomcat使用的的默认解码方式不是utf-8，就出现了乱码，并且tomcat没有提供设置解码方式的接口


        //过程：
        /*String username="张三";
        //浏览器使用utf-8进行编码
        String encode = URLEncoder.encode(username,"utf-8");
        System.out.println(encode);
        //tomcat使用ISO-8859-1进行解码
        String decode = URLDecoder.decode(encode, "ISO-8859-1");
        //最终输出乱码
        System.out.println(decode);*/


        //解决原理：乱码和汉字底层二进制是一样的
        //username为tomcat使用ISO-8859-1解码后的乱码
        String username = req.getParameter("username");
        //程序员要做的事：
        // 转为字节数组
        byte[] bytes = username.getBytes("ISO-8859-1");
        //转为字符串
        username = new String(bytes,"utf-8");
        System.out.println(username);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post方式：设置字符流的编码方式
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        System.out.println(username);
    }
}
