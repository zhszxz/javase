package com.atguigu.mvc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.hsf.HSFJSONUtils;
import com.atguigu.mvc.bean.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Date:2021/7/9
 * Author:ybc
 * Description:
 */
@Controller
public class HttpController {
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestbody) {
        System.out.println(requestbody);
        return "success";
    }

    @RequestMapping(value = "/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity) throws UnsupportedEncodingException {
        HttpHeaders headers = requestEntity.getHeaders();
        String body = requestEntity.getBody();
        System.out.println("请求头：" + headers);
        System.out.println("请求体：" + URLDecoder.decode(body, "utf-8"));
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().write("<h1>hello respone!</h1>");
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody//加了这个注解方法的返回值不再表示视图名称，而是响应的响应体
    public String testResponseBody() {
        return "success";//直接在浏览器页面显示success，而不是跳转到success.html
    }

    @RequestMapping("/testResponseObj")
    @ResponseBody
    public User testResponseObj() {
        User user = new User(1001, "admin", "123456", 23, "男");
        return user;
    }

    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username, String password) {
        System.out.println(username + ", " + password);
        return "hello axios!";
    }

}
