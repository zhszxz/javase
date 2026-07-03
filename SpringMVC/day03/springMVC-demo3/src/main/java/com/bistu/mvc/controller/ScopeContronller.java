package com.bistu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeContronller {
    //向request域共享数据，原生做法
    @RequestMapping("/testRequestByServletAPI")
    public String RequestByServletAPI(HttpServletRequest request) {
        request.setAttribute("index", "hello ServletAPI!");
        return "success";
    }

    //向request域共享数据，使用modelandview对象
    //无论使用何种方式向request域共享数据，最终都会封装为ModelAndView对象
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("index", "hello ModelAndView!");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    //向request域共享数据，使用model对象
    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("index", "hello Model!");
        System.out.println(model.getClass().getName());
        return "success";
    }

    //向request域共享数据，使用Map集合
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("index", "hello Map!");
        System.out.println(map.getClass().getName());
        return "success";
    }

    //向request域共享数据，使用ModelMap
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("index", "hello ModelMap!");
        System.out.println(modelMap.getClass().getName());
        return "success";
    }

    //向session域共享数据，建议使用ServletAPI原生方式
    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("index","hello session!");
        return "success";
    }

    //向Application域共享数据
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        ServletContext application = session.getServletContext();
        application.setAttribute("index","hello application!");
        return "success";
    }

}
