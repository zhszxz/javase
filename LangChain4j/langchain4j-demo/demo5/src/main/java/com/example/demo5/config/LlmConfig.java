package com.example.demo5.config;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiEmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
public class LlmConfig {

    @Value("${openai.chatmodel.baseurl}")
    String chatModelBaseUrl;

    @Value("${openai.chatmodel.apikey}")
    String chatModelApiKey;

    @Value("${openai.chatmodel.modelname}")
    String chatModelName;

    @Value("${openai.embeddingmodel.baseurl}")
    String embeddingModelBaseUrl;

    @Value("${openai.embeddingmodel.apikey}")
    String embeddingModelApiKey;

    @Value("${openai.embeddingmodel.modelname}")
    String embeddingModelName;

    //聊天模型
    @Bean
    public ChatLanguageModel chatLanguageModel() {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl(chatModelBaseUrl)
                .apiKey(chatModelApiKey)
                .modelName(chatModelName)
                .build();
        return model;
    }

    //向量化模型
    @Bean
    public EmbeddingModel embeddingModel() {
        OpenAiEmbeddingModel embeddingModel = OpenAiEmbeddingModel.builder()
                .baseUrl(embeddingModelBaseUrl)
                .apiKey(embeddingModelApiKey)
                .modelName(embeddingModelName)
                .build();
        return embeddingModel;
    }

    //向量存储
    @Bean
    public EmbeddingStore<TextSegment> embeddingStore() {
        return new InMemoryEmbeddingStore<>();
    }

}
