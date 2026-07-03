package com.bistu.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ResultSet {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取链接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String passord = "739627";

        Connection conn = DriverManager.getConnection(url, username, passord);
        //定义sql语句
        String querysql = "select * from account";
        //获取执行sql的对象
        java.sql.Statement st = conn.createStatement();
        //执行sql
        //executeQuery()返回查询结果集
        java.sql.ResultSet resultSet = st.executeQuery(querysql);
        ArrayList<Account> list=new ArrayList<>();
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int money = resultSet.getInt(3);
            list.add(new Account(id,name,money));
        }
        System.out.println(Arrays.toString(list.toArray()));
        //释放资源
        resultSet.close();
        st.close();
        conn.close();
    }
}
