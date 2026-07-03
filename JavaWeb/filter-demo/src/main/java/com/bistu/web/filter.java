package com.bistu.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//过滤器要过滤的请求针对的资源路径，/*表示对任意资源的请求都会被过滤
@WebFilter("/index.jsp")
public class filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //放行前逻辑
        System.out.println("1.Filter方形前");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
        //放行后逻辑
        System.out.println("3.Filter放行后");
    }

    @Override
    public void destroy() {

    }
}
