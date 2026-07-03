package com.bistu.JDBC;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
    public static void main(String[] args) throws Exception {

        //API  java.sql.Collection事务管理演示

        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取链接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String passord = "739627";

        //Connection类的两个作用：1.获取执行sql的对象 2.事务管理
        java.sql.Connection conn = DriverManager.getConnection(url, username, passord);

        //定义sql语句
        String sql1 = "update account set money=money-1000 where name='张三'";
        String sql2 = "update account set money=money+1000 where name='李四'";

        //获取执行sql的对象
        Statement st = conn.createStatement();

        try {
            //开启事务
            conn.setAutoCommit(false);
            //执行sql
            int line1 = st.executeUpdate(sql1);
            System.out.println("受影响的行数为" + line1);

            //出现异常
            int i=1/0;

            int line2 = st.executeUpdate(sql2);
            System.out.println("受影响的行数为" + line2);
            conn.commit();

        } catch (SQLException e) {
            conn.rollback();
            throw new Exception(e);
        }

        //释放资源
        st.close();
        conn.close();

    }
}
