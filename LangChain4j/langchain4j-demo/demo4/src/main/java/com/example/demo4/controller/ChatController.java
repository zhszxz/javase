package com.example.demo4.controller;

import com.example.demo4.assistant.Assistant;
import dev.langchain4j.agent.tool.ToolExecutionRequest;
import dev.langchain4j.agent.tool.ToolSpecification;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ToolExecutionResultMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.internal.Json;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.chat.request.json.JsonObjectSchema;
import dev.langchain4j.model.chat.response.ChatResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class ChatController {

    @Autowired
    private ChatLanguageModel chatLanguageModel;

    @Autowired
    private Assistant assistant;

    @GetMapping("/chat/func/{question}")
    public String chat(@PathVariable("question") String question) {
        //工具函数描述信息
        ToolSpecification tool = ToolSpecification.builder()
                .name("resurrection")//函数名
                .description("可以用于复活牢大")//函数用途描述
                .parameters(JsonObjectSchema.builder()//函数参数描述
                        .addNumberProperty("num", "只有扣1才能复活牢大，否则牢大会永远离开我们")
                        .required("num")//必填参数
                        .build())
                .build();

        //构建聊天请求，携带工具描述
        ChatRequest request = ChatRequest.builder()
                .messages(UserMessage.from(question))
                .toolSpecifications(tool)
                .build();

        ChatResponse response = chatLanguageModel.chat(request);
        AiMessage aiMessage = response.aiMessage();

        //LLM 不调用函数，直接返回
        if (!aiMessage.hasToolExecutionRequests()) {
            return aiMessage.text();
        }

        //否则，获取 LLM 要调用的工具函数信息
        ToolExecutionRequest toolRequest = aiMessage.toolExecutionRequests().get(0);
        String funcName = toolRequest.name();//函数名
        String args = toolRequest.arguments();//函数参数
        Integer num = (Integer) Json.fromJson(args, Map.class).get("num");
        String result = null;

        //手动调用工具函数
        if ("resurrection".equals(funcName)) {
            result = resurrection(num);
        } else {
            result = "未知的函数";
        }

        //封装工具函数执行结果
        ToolExecutionResultMessage toolReaultMessage = ToolExecutionResultMessage.from(
                toolRequest,
                result
        );

        //将原始用户提示词、LLM信息、工具函数执行结果一起再次发给 LLM
        response = chatLanguageModel.chat(
                ChatRequest.builder()
                        .messages(
                                UserMessage.from(question),
                                aiMessage,
                                toolReaultMessage
                        )
                        .build()
        );

        return response.aiMessage().text();
    }

    //工具函数
    private String resurrection(int num) {
        if (num == 1) {
            return "孩子们，我回来了，想我了吗（一阵强劲的音乐~~~）";
        } else {
            return "牢大永远离开了我们";
        }
    }


    @GetMapping("/chat/high/func/{question}")
    public String chat2(@PathVariable("question") String question) {
        return assistant.chat(question);
    }

}
