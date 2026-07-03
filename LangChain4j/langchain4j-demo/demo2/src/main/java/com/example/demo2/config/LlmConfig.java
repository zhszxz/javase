package com.example.demo2.config;

import com.example.demo2.assistant.Assistant;
import com.example.demo2.utils.RedisUtil;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.ChatMessageDeserializer;
import dev.langchain4j.data.message.ChatMessageSerializer;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.memory.chat.ChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LlmConfig {

    @Value("${openai.baseurl}")
    String baseUrl;

    @Value("${openai.apikey}")
    String apiKey;

    @Value("${openai.modelname}")
    String modelName;

    @Autowired
    RedisUtil redisUtil;

    //@Bean
    public Assistant assistant() {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl(baseUrl)
                .apiKey(apiKey)
                .modelName(modelName)
                .build();

        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(model)
                //对话记忆提供者 MessageWindowChatMemory : 保留最近10条消息
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.withMaxMessages(10))
                .build();
        return assistant;
    }


    @Bean
    public Assistant ChatMemoryStoreAssistant() {
        //兜底模型
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl(baseUrl)
                .apiKey(apiKey)
                .modelName(modelName)
                .build();

        //会话历史持久化组件
        ChatMemoryStore chatMemoryStore = new ChatMemoryStore() {
            @Override
            public List<ChatMessage> getMessages(Object o) { //获取 ChatMeaasge 时调用
                String json = redisUtil.get((String) o);
                return ChatMessageDeserializer.messagesFromJson(json);
            }

            @Override
            public void updateMessages(Object o, List<ChatMessage> list) { //更新 ChatMeaasge 时调用
                String json = ChatMessageSerializer.messagesToJson(list);
                redisUtil.set((String) o, json);
            }

            @Override
            public void deleteMessages(Object o) { //删除 ChatMessage 时调用
                redisUtil.delete((String) o);
            }
        };

        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(model)//模型
                .chatMemoryProvider(memoryId -> MessageWindowChatMemory.builder()//会话记忆
                        .id(memoryId)
                        .maxMessages(10)
                        .chatMemoryStore(chatMemoryStore)//会话历史持久化
                        .build())
                .build();
        return assistant;
    }

}
