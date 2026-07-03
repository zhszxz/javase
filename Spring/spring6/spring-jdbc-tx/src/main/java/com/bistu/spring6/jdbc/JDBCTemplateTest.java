package com.bistu.spring6.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JDBCTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate() {
        //添加操作
         /*String sql ="insert into t_emp values(null,?,?,?)";
        int line = jdbcTemplate.update(sql, "王五", "25", "男");
        if(line>0){
            System.out.println("操作成功！");
        }*/
        //修改操作
       /* String sql ="update t_emp set name=? where id=?";
        int line = jdbcTemplate.update(sql, "李四", "1");
        if(line>0){
            System.out.println("操作成功！");
        }*/
        //删除操作
        /*String sql = "delete from t_emp where name=?";
        int line = jdbcTemplate.update(sql, "李四");
        if (line > 0) {
            System.out.println("操作成功！");
        }*/
    }
    @Test
    public void teatQuaryObj(){
        //查询操作，返回单个对象

        String sql ="select * from t_emp where id=?";
        /*手动封装
        emp empResult=(emp)jdbcTemplate.queryForObject(sql, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                emp emp = new emp();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setAge(rs.getInt("age"));
                emp.setSex(rs.getString("sex"));
                return emp;
            }
        }, 3);
        System.out.println(empResult);*/
        //自动封装
        emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(emp.class), 4);
        System.out.println(emp);
    }

    @Test
    //查询返回集合
    public void testQuaryList(){
        String sql="select * from t_emp";
        List<emp> emps = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(emp.class));
        System.out.println(emps);
    }

    @Test
    public void testSelectValue(){
     String sql ="select count(*) from t_emp where sex=?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, "女");
        System.out.println(count);
    }


}
