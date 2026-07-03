package com.example.demo5.controller;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingMatch;
import dev.langchain4j.store.embedding.EmbeddingSearchRequest;
import dev.langchain4j.store.embedding.EmbeddingStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
public class ChatController {

    private static final String documentsLocation = "D:/Java/idea-WorkSpace/LangChain4j/langchain4j-demo/demo5/src/main/resources/document";

    @Autowired
    private ChatLanguageModel chatLanguageModel;

    @Autowired
    private EmbeddingModel embeddingModel;

    @Autowired
    private EmbeddingStore<TextSegment> embeddingStore;

    /**
     * 文档入库
     *
     * @return
     */
    @GetMapping("/document/embedding")
    public String documentEmbedding() {
        //将文件加载为 Document
        List<Document> documents = FileSystemDocumentLoader.loadDocuments(documentsLocation);
        for (Document document : documents) {
            TextSegment textSegment = document.toTextSegment();//每个文档转为一个 TextSegment
            Embedding embedding = embeddingModel.embed(textSegment).content();//TextSegment 向量化
            embeddingStore.add(embedding, textSegment);//向量和原始文本段一起入库
        }
        return "success";
    }

    @GetMapping("/chat/rag/{question}")
    public String chat(@PathVariable("question") String question) {
        Embedding embedding = embeddingModel.embed(question).content();//问题向量化
        //检索相关文档
        List<EmbeddingMatch<TextSegment>> matches = embeddingStore.search(
                EmbeddingSearchRequest.builder()
                        .queryEmbedding(embedding)//问题向量
                        .minScore(0.5)//最小相似度得分
                        .maxResults(5)//最大召回文档数
                        .build()
        ).matches();

        //将命中的文档和问题一起发给 LLM
        String context = matches.stream().map(each -> each.embedded().text()).collect(Collectors.joining("\n"));
        String prompt = """
                请根据以下资料（如果有）回答问题：
                ----------------
                %s
                ----------------
                问题：%s
                """.formatted(context, question);

        return chatLanguageModel.chat(prompt);
    }

}
