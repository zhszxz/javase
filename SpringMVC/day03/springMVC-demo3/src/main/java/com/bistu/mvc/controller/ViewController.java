package com.bistu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/testThymeleafView")
    public String testThymeleafView() {
//ThymeleafView：当控制器方法中所设置的视图名称没有任何前缀时，此时的视图名称会被SpringMVC配置文件中所配置的视图解析器解析，
// 视图名称拼接视图前缀和视图后缀所得到的最终路径，会通过转发的方式实现跳转
        return "success";
    }

    @RequestMapping("/testForward")
    public String testForward() {
        //当控制器方法中所设置的视图名称以"forward:"为前缀时，创建InternalResourceView视图，
        // 此时的视图名称不会被SpringMVC配置文件中所配置的视图解析器解析，
        // 而是会将前缀"forward:"去掉，剩余部分作为最终路径通过转发的方式实现跳转
        return "forward:/testThymeleafView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect() {
        //当控制器方法中所设置的视图名称以"redirect:"为前缀时，创建RedirectView视图，
        // 此时的视图名称不会被SpringMVC配置文件中所配置的视图解析器解析，
        // 而是会将前缀"redirect:"去掉，剩余部分作为最终路径通过重定向的方式实现跳转
        return "redirect:/testThymeleafView";
    }

}
