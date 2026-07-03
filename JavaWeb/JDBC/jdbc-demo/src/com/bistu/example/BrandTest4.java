package com.bistu.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BrandTest4 {
    public static void main(String[] args) throws Exception {
        //数据库删除

        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接数据库
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "739627";

        Connection conn = DriverManager.getConnection(url, username, password);
        //模拟用户输入
        int id = 1;
        //定义sql语句
        String sql = "delete from tb_brand where id=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //设置参数
        pstmt.setInt(1, id);
        //执行sql语句
        int line = pstmt.executeUpdate();
        System.out.println(line > 0);
    }
}
