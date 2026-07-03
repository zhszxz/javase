package com.example.demo3.assistant;

import dev.langchain4j.service.ChatMemoryAccess;
import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.TokenStream;
import dev.langchain4j.service.UserMessage;

public interface StreamingAssistant extends ChatMemoryAccess {
    TokenStream chatStream(@MemoryId int memoryId, @UserMessage String message);
}
