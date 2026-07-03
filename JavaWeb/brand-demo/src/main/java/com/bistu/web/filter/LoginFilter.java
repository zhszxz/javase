package com.bistu.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        //如果访问的资源与登录注册相关，应该放行
        String[] urls = {"/login.jsp","/register.html","/imgs/","/css/","/loginServlet","/register.jsp","/registerServlet","/checkCodeServlet"};
        // 获取当前访问的资源路径
        String url = req.getRequestURL().toString();
        for (String s : urls) {
            if (url.contains(s)){
                filterChain.doFilter(req,servletResponse);
                return;
            }
        }

        //从sesson中获取user对象
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        //非null说明已登陆
        if(user!=null){
            filterChain.doFilter(req,servletResponse);
        }
        //否则跳转登陆并提示
        else{
            req.setAttribute("login_msg","您尚未登陆！");
            req.getRequestDispatcher("/login.html").forward(req,servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
