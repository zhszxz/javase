package com.bistu.JDBC;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PreparedStatement{
    //解决sql注入
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取链接
        String url = "jdbc:mysql://127.0.0.1:3306/ordersystem";
        String username = "root";
        String password = "739627";

        Connection conn = DriverManager.getConnection(url, username, password);
        //sql注入
        String name = "sfdssc";
        String userpassword = "' or '1'='1";
        //定义sql语句
        //用占位符代替字符串拼接
        String querysql = "select * from userinfo where username=? and password=?";

        //执行sql语句
        java.sql.PreparedStatement pstmt = conn.prepareStatement(querysql);
        //替换占位符
        //参数一：？的位置，从1开始
        //参数二：用来替换？的值
        pstmt.setString(1,name);
        pstmt.setString(2,userpassword);
        ResultSet resultSet = pstmt.executeQuery();

        if(resultSet.next()){
            System.out.println("登陆成功");
        }else{
            System.out.println("登陆失败");
        }
    }
}
