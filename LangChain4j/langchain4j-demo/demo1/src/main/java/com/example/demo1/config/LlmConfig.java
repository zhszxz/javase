package com.example.demo1.config;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
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

    @Bean
    public ChatLanguageModel chatLanguageModel() {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl(baseUrl)
                .apiKey(apiKey)
                .modelName(modelName)
                .build();
        return model;
    }

    @Bean("streamingChatLanguageModel")
    public StreamingChatLanguageModel StreamingChatLanguageModel() {
        OpenAiStreamingChatModel model = OpenAiStreamingChatModel.builder()
                .baseUrl(baseUrl)
                .apiKey(apiKey)
                .modelName(modelName)
                .build();
        return model;
    }

}
