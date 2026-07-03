package com.bistu.web;

import com.bistu.mapper.UserMapper;
import com.bistu.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.bistu.util.sqlSessionFactoryUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("register...");
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByUsername(username);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();

        if (user != null) {
            writer.write("注册失败，用户名已存在！");
        } else {
            mapper.add(new User(username,password));
            sqlSession.commit();
            writer.write("注册成功！");
        }

        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
