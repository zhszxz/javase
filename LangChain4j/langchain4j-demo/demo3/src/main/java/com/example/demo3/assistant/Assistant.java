package com.example.demo3.assistant;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

//public interface Assistant {
//    //指定系统提示词
//    @SystemMessage("You are a good friend of mine. Answer using slang.")
//    String chat(String userMessage);
//}

public interface Assistant {
    //指定用户提示词模板
    @UserMessage("You are a good friend of mine. Answer using slang. {{it}}")
    String chat(String userMessage);
}
