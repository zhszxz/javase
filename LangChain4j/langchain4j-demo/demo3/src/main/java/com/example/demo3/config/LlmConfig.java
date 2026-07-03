package com.example.demo3.config;


import com.example.demo3.assistant.Assistant;
import com.example.demo3.assistant.StreamingAssistant;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LlmConfig {

    @Value("${openai.baseurl}")
    String baseUrl;

    @Value("${openai.apikey}")
    String apiKey;

    @Value("${openai.modelname}")
    String modelName;


//    @Bean
//    public Assistant assistant() {
//        OpenAiChatModel model = OpenAiChatModel.builder()
//                .baseUrl(baseUrl)
//                .apiKey(apiKey)
//                .modelName(modelName)
//                .build();
//
//        Assistant assistant = AiServices.builder(Assistant.class)
//                .chatLanguageModel(model)
//                .systemMessageProvider(memoryId -> "You are a good friend of mine. Answer using slang.")
//                .build();
//        return assistant;
//    }

    @Bean
    public Assistant assistant() {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl(baseUrl)
                .apiKey(apiKey)
                .modelName(modelName)
                .build();

        Assistant assistant = AiServices.create(Assistant.class, model);
        return assistant;
    }

    @Bean
    public StreamingAssistant streamingAssistant() {
        OpenAiStreamingChatModel model = OpenAiStreamingChatModel.builder()
                .baseUrl(baseUrl)
                .apiKey(apiKey)
                .modelName(modelName)
                .build();

        StreamingAssistant streamingAssistant = AiServices.builder(StreamingAssistant.class)
                .streamingChatLanguageModel(model)
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
                .build();
        return streamingAssistant;
    }

}
