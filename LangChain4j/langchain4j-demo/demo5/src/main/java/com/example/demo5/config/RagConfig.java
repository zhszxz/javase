package com.example.demo5.config;

import com.example.demo5.config.properties.ChatModelProperties;
import com.example.demo5.config.properties.EmbeddingModelProperties;
import com.example.demo5.config.properties.MilvusProperties;
import dev.langchain4j.data.document.DocumentSplitter;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiEmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.milvus.MilvusEmbeddingStore;
import dev.langchain4j.data.document.splitter.DocumentByParagraphSplitter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({ChatModelProperties.class, EmbeddingModelProperties.class, MilvusProperties.class})
@Configuration
@RequiredArgsConstructor
public class RagConfig {

    private final ChatModelProperties chatModelProperties;

    private final EmbeddingModelProperties embeddingModelProperties;

    private final MilvusProperties milvusProperties;

    /**
     * 聊天模型
     */
    @Bean
    public ChatLanguageModel chatLanguageModel() {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl(chatModelProperties.getBaseurl())
                .apiKey(chatModelProperties.getApikey())
                .modelName(chatModelProperties.getModelname())
                .build();
        return model;
    }

    /**
     * 向量化模型
     */
    @Bean
    public EmbeddingModel embeddingModel() {
        OpenAiEmbeddingModel embeddingModel = OpenAiEmbeddingModel.builder()
                .baseUrl(embeddingModelProperties.getBaseurl())
                .apiKey(embeddingModelProperties.getApikey())
                .modelName(embeddingModelProperties.getModelname())
                .build();
        return embeddingModel;
    }

    /**
     * 向量化存储配置
     *
     * @return
     */
    @Bean
    public EmbeddingStore<TextSegment> embeddingStore(EmbeddingModel embeddingModel) {

        int dimension = embeddingModel
                .embed("dimension-check")
                .content()
                .vector()
                .length;

        return MilvusEmbeddingStore.builder()
                .host(milvusProperties.getHost())
                .port(milvusProperties.getPort())
                .collectionName(milvusProperties.getCollectionname())//Collection 名称
                .dimension(dimension)//向量维度长度，需与向量化模型输出长度一致
                .retrieveEmbeddingsOnSearch(true)//是否取回命中的原始 TextSegment
                .build();
    }

    /**
     * 文档切分器
     */
    @Bean
    public DocumentSplitter documentSplitter() {
        //分片长度和字符重叠
        return new DocumentByParagraphSplitter(500, 50);
    }

}
