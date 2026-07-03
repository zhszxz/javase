package com.bistu.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserLogin {
    //sql注入 用户登录案例
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取链接
        String url = "jdbc:mysql://127.0.0.1:3306/ordersystem";
        String username = "root";
        String passord = "739627";

        Connection conn = DriverManager.getConnection(url, username, passord);
        //sql注入
        String name = "vnfnxdsds";
        String password = "' or '1'='1";
        //定义sql语句
        String querysql = "select * from userinfo where username='" + name + "' and password='" + password + "'";
        System.out.println(querysql);
        //执行sql语句
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery(querysql);
        if(resultSet.next()){
            System.out.println("登陆成功");
        }else{
            System.out.println("登陆失败");
        }
    }
}
