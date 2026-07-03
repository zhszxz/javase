package com.bistu.springboot3demo4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bistu.springboot3demo4.bean.Person;

import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {
    @GetMapping("/wel")
    public String welcome(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "welcome";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Person> list = Arrays.asList(
                new Person(1L, "张三1", "", 15,"pm"),
                new Person(3L, "张三2", "zs2@qq.com", 16,"pm"),
                new Person(4L, "张三333", "zs3@qq.com", 17,"pm"),
                new Person(7L, "张三444", "zs4@qq.com", 18,"admin"),
                new Person(8L, "张三5", "zs5@qq.com", 19,"hr")
        );



        model.addAttribute("persons",list);

//        int i = 10/0;
        return "list";
    }

}
