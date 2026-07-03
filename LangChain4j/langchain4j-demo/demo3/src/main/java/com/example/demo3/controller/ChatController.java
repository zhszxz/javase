package com.example.demo3.controller;

import com.example.demo3.assistant.Assistant;
import com.example.demo3.assistant.StreamingAssistant;
import dev.langchain4j.service.TokenStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@Slf4j
@RestController
public class ChatController {

    @Autowired
    private Assistant assistant;

    @Autowired
    private StreamingAssistant streamingAssistant;

    @GetMapping("/chat/{question}")
    public String chat(@PathVariable("question") String question) {
        String resp = assistant.chat(question);//Hello!
        return resp;//Sup, bestie! 😎 What's crackin'? Hope you're slayin' today! 💖
    }

    @GetMapping(value = "/stream/chat/{question}", produces = "text/plain;charset=UTF-8")
    public Flux<String> chatStream(@PathVariable("question") String question) {
        TokenStream tokenStream = streamingAssistant.chatStream(0, question);
        return Flux.create(emitter -> {
            tokenStream.onPartialResponse(token -> emitter.next(token))
                    .onCompleteResponse(resp -> emitter.complete())
                    .onError(emitter::error)
                    .start();
        }, FluxSink.OverflowStrategy.BUFFER);
    }

    @GetMapping(value = "/stream/chat", produces = "text/plain;charset=UTF-8")
    public Flux<String> chatMemory(@RequestParam("memoryId") int memoryId, @RequestParam("question") String question) {
        TokenStream tokenStream = streamingAssistant.chatStream(memoryId, question);
        return Flux.create(emitter -> {
            tokenStream.onPartialResponse(token -> emitter.next(token))
                    .onCompleteResponse(resp -> emitter.complete())
                    .onError(emitter::error)
                    .start();
        }, FluxSink.OverflowStrategy.BUFFER);
    }
}
