package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class ParamController {

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request) {
        //第一次获取session时会创建一个cookie，然后将session存储到服务器端的map集合作为值，键为cookie的JSESSIONID
        //然后将cookie加到响应报文中响应给浏览器端
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:" + username + "  " + "password:" + password);
        return "success";
    }

    //保证参数名与请求参数名一致即可自动赋值
    @RequestMapping("/testParam")
    //获取多个同名的的请求参数，可以用String来接收，会将参数拼接起来，用,分隔
    //也可以用String[]来接收
    //public String testParam(String username, String password, String hobby) {
    //当没有传输请求参数或请求参数为空字符串的时候，defaultvalue生效
    public String testParam(@RequestParam(value = "user_name", required = false, defaultValue = "zhangsan") String username,
                            String password,
                            String[] hobby,
                            //获取请求头信息
                            @RequestHeader("Host") String host,
                            //获取cookie信息
                            @CookieValue("JSESSIONID") String JSESSIONID) {
        //System.out.println("username:" + username + "  password:" + password + "  hobby:" + hobby);
        System.out.println("username:" + username + "  password:" + password + "  hobby:" + Arrays.toString(hobby));
        System.out.println("host:" + host);
        System.out.println("JSESSIONID:" + JSESSIONID);
        return "success";
    }

    @RequestMapping("/testBean")
    //自动封装请求参数到pojo类对象中，需要保证请求参数name与实体类的属性名一致
    public String testBean(User user) {
        System.out.println(user);
        return "success";
    }

}
