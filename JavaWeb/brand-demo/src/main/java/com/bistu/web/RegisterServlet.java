package com.bistu.web;

import com.bistu.pojo.User;
import com.bistu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);

        /*String checkCode = req.getParameter("checkCode");
        HttpSession session = req.getSession();
        String checkcode = (String)session.getAttribute("checkcode");
        if(!checkcode.equalsIgnoreCase(checkCode)){
            req.setAttribute("register_msg","验证码错误！");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
            return;
        }*/

        if(service.register(u)){
            req.setAttribute("register_msg","注册成功，请登录：");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
        else {
            req.setAttribute("register_msg","注册失败，请重试！");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
