package com.bistu.JDBC;

import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcdemo {
    public static void main(String[] args) throws Exception {

        //注册驱动,mysql5以后可以省略不写
        //Driver底层有一个进静态代码块，使用Class.forName()方法加载该类后自动执行，
        // 调用DriverManager类的registerDriver方法注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //获取链接
        String url = "jdbc:mysql://127.0.0.1:3306/db1";
        String username = "root";
        String passord = "739627";

        Connection conn = DriverManager.getConnection(url, username, passord);
        //定义sql语句
        String sql = "update account set money=2000 where name='张三'";
        String querysql = "select * from emp";
        //获取执行sql的对象
        //Statement类的作用：1：执行sql语句
        java.sql.Statement st = conn.createStatement();
        //执行sql
        //1.executeUpdate()方法执行dml语句返回受影响行数，执行ddl语句即使成功也可能返回0
        int line = st.executeUpdate(sql);
        //处理结果
        if(line>0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }

        //2.executeQuery()返回查询结果集
        ResultSet resultSet = st.executeQuery(querysql);
        StringBuilder sb=new StringBuilder();
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String job= resultSet.getString(4);
            Double salary = resultSet.getDouble(5);
            Date entrtdate = resultSet.getDate(6);
            sb.append(id+", ");
            sb.append(name+", ");
            sb.append(age+", ");
            sb.append(job+", ");
            sb.append(salary+", ");
            sb.append(entrtdate);
            System.out.println(sb.toString());
            sb.delete(0,sb.length());
        }
        //释放资源
        resultSet.close();
        st.close();
        conn.close();

    }
}
