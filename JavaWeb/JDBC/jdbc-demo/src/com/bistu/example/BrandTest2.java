package com.bistu.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BrandTest2 {
    public static void main(String[] args) throws Exception {
        //数据库插入功能

        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接数据库
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String password = "739627";

        Connection conn = DriverManager.getConnection(url, username, password);
        //模拟用户输入
        String brandName = "香飘飘";
        String companyName = "香飘飘公司";
        int ordered = 1;
        String des = "一年卖出三亿杯";
        int status = 1;
        //定义sql语句
        String sql = "insert into tb_brand (brand_name, company_name, ordered, description, status) values (?,?,?,?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        //设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,des);
        pstmt.setInt(5,status);

        //执行sql语句
        int line = pstmt.executeUpdate();
        System.out.println(line>0);
    }
}
