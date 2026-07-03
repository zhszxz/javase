package com.example.demo4.config;

import com.example.demo4.assistant.Assistant;
import com.example.demo4.utils.LlmUtil;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
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

    @Bean
    public ChatLanguageModel chatLanguageModel() {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl(baseUrl)
                .apiKey(apiKey)
                .modelName(modelName)
                .build();
        return model;
    }

    @Bean
    public Assistant assistant() {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl(baseUrl)
                .apiKey(apiKey)
                .modelName(modelName)
                .build();

        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(model)
                .tools(new LlmUtil())//创建时携带工具描述信息
                .build();

        return assistant;
    }

}
