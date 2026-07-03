package com.bistu.web;

import com.bistu.pojo.User;
import com.bistu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.bistu.service.UserService;

import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = service.login(username, password);

        if(user!=null){
            if("1".equals(req.getParameter("remember"))){
                Cookie c_username = new Cookie("username",username);
                Cookie c_password = new Cookie("password",password);
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);
                resp.addCookie(c_username);
                resp.addCookie(c_password);
            }

            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath+"/selectAllServlet");
        }
        else {
            req.setAttribute("login_msg","用户名或密码不正确！");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
