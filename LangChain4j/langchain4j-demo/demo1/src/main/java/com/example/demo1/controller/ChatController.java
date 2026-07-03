package com.example.demo1.controller;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.chat.response.ChatResponseMetadata;
import dev.langchain4j.model.chat.response.StreamingChatResponseHandler;
import dev.langchain4j.model.output.TokenUsage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

@Slf4j
@RestController
public class ChatController {

    @Autowired
    public ChatLanguageModel chatLanguageModel;

    @Autowired
    private StreamingChatLanguageModel streamingChatLanguageModel;

    @GetMapping("/chat/{question}")
    public String chat(@PathVariable(value = "question") String question) {
        return chatLanguageModel.chat(question);
    }

    @GetMapping("/chat2/{question}")
    public String chat2(@PathVariable(value = "question") String question) {
        UserMessage message = UserMessage.from(question);
        ChatResponse response = chatLanguageModel.chat(message);
        //获取token消耗
        ChatResponseMetadata metadata = response.metadata();
        TokenUsage tokenUsage = metadata.tokenUsage();
        //或者直接
        //TokenUsage tokenUsage = response.tokenUsage();
        Integer inputTokenCount = tokenUsage.inputTokenCount();//输入token
        Integer outputTokenCount = tokenUsage.outputTokenCount();//输出token
        Integer totalTokenCount = tokenUsage.totalTokenCount();//总token
        log.info("调用模型完成，输入token={}，输出token={}，总token={}", inputTokenCount, outputTokenCount, totalTokenCount);
        //返回模型响应
        AiMessage aiMessage = response.aiMessage();
        return aiMessage.text();
    }

    @GetMapping("/chat3")
    public String chat3() throws IOException {
        File file = new File("C:/Users/user/Pictures/Saved Pictures/image.jpg");
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = fis.readAllBytes();
        fis.close();
        String base64 = Base64.getEncoder().encodeToString(bytes);
        UserMessage message = UserMessage.from(
                TextContent.from("以下两张图片内容是什么？"),
                ImageContent.from("https://picsum.photos/200/300"),
                ImageContent.from(base64, "image/jpg")
        );
        ChatResponse response = chatLanguageModel.chat(message);
        return response.aiMessage().text();
    }

    @GetMapping("/chat4/stream")
    public SseEmitter chatStream(@RequestParam String question) {
        SseEmitter sseEmitter = new SseEmitter(0L);//不超时
        streamingChatLanguageModel.chat(question, new StreamingChatResponseHandler() {
            @Override
            public void onPartialResponse(String s) {
                try {
                    sseEmitter.send(s);
                } catch (Exception e) {
                    sseEmitter.completeWithError(e);
                }
            }

            @Override
            public void onCompleteResponse(ChatResponse chatResponse) {
                sseEmitter.complete();
            }

            @Override
            public void onError(Throwable throwable) {
                sseEmitter.completeWithError(throwable);
            }
        });
        return sseEmitter;
    }

}
