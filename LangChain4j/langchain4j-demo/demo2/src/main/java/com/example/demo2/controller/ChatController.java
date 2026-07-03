package com.example.demo2.controller;

import com.example.demo2.assistant.Assistant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ChatController {

    @Autowired
    private Assistant assistant;


    @GetMapping("/chat/memory")
    public void chat() {
        String resp1 = assistant.chat("用户1", "hello my name is golang");
        log.info("LLM resp:[{}]", resp1); //Hello, Golang! 👋
        String resp2 = assistant.chat("用户2", "hello my name is c++");
        log.info("LLM resp:[{}]", resp2); //Hello, C++! 👋
        String resp3 = assistant.chat("用户1", "what is my name");
        log.info("LLM resp:[{}]", resp3); //Your name is Golang
        String resp4 = assistant.chat("用户2", "what is my name");
        log.info("LLM resp:[{}]", resp4); //Your name is C++
    }

    @GetMapping("/chat/history")
    public String chatHistory(@RequestParam String memoryId, @RequestParam String question) {
        String resp = assistant.chat(memoryId, question);
        log.info("LLM resp:[{}]", resp);
        return resp;
    }
}
