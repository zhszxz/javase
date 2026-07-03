package com.example.demo2.assistant;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;

public interface Assistant {
    /**
     * @param memoryId    记忆ID
     * @param userMessage 用户消息
     * @return
     */
    String chat(@MemoryId String memoryId, @UserMessage String userMessage);
}
