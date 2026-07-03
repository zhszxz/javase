package com.bistu.example;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BrandTest {
    public static void main(String[] args) throws Exception {
        //数据库查询功能
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String passord = "739627";
        java.sql.Connection conn = DriverManager.getConnection(url, username, passord);

        String sql = "select * from tb_brand";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        List<Brand> list = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt(1);
            String bname = rs.getString(2);
            String cname = rs.getString(3);
            int order = rs.getInt(4);
            String des = rs.getString(5);
            int staus = rs.getInt(6);
            list.add(new Brand(id, bname, cname, order, des, staus));
        }

        System.out.println(list);

        rs.close();
        pstmt.close();
        conn.close();
    }
}
