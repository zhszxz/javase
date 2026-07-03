package com.example.demo5.controller;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.DocumentSplitter;
import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.input.PromptTemplate;
import dev.langchain4j.store.embedding.EmbeddingMatch;
import dev.langchain4j.store.embedding.EmbeddingSearchRequest;
import dev.langchain4j.store.embedding.EmbeddingStore;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
@RestController
public class RagChatController {

    @Autowired
    private ChatLanguageModel chatLanguageModel;

    @Autowired
    private EmbeddingModel embeddingModel;

    @Autowired
    private EmbeddingStore<TextSegment> embeddingStore;

    @Autowired
    private DocumentSplitter documentSplitter;

    private final String PROMPT_TEMPLATE_WHEN_HITTING = """
            请根据以下资料回答问题：
                ----------------
               {{context}}
                ----------------
                问题：{{question}}
            """;
    private final String PROMPT_TEMPLATE_WHEN_NOT_HITTING = """
            请回答以下问题：
              {{question}}
            """;

    /**
     * 上传文档并向量化存储
     *
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/document/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        //1.解析文本内容
        Tika tika = new Tika();
        String content = tika.parseToString(file.getInputStream());

        //2.文档分片
        Document document = Document.from(content);
        List<TextSegment> textSegments = documentSplitter.split(document);

        //3.分片向量化存储
        for (TextSegment textSegment : textSegments) {
            Embedding embedding = embeddingModel.embed(textSegment).content();
            embeddingStore.add(embedding, textSegment);
        }
        return "upload success, segments=" + textSegments.size();
    }

    @GetMapping("/chat/{question}")
    public String chat(@PathVariable("question") String question) {
        Embedding embedding = embeddingModel.embed(question).content();//问题向量化
        //检索相关文档
        List<EmbeddingMatch<TextSegment>> matches = embeddingStore.search(
                EmbeddingSearchRequest.builder()
                        .queryEmbedding(embedding)//问题向量
                        .minScore(0.6)//最小相似度得分
                        .maxResults(5)//最大召回文档数
                        .build()
        ).matches();

        //将命中的文档和问题一起发给 LLM
        String prompt = "";
        if (matches.size() > 0) {
            String context = matches.stream().map(each -> each.embedded().text()).collect(Collectors.joining("\n"));
            prompt = PromptTemplate.from(PROMPT_TEMPLATE_WHEN_HITTING)
                    .apply(Map.of(
                            "context", context,
                            "question", question
                    )).text();
        } else {
            prompt = PromptTemplate.from(PROMPT_TEMPLATE_WHEN_NOT_HITTING)
                    .apply(Map.of("question", question)).text();
        }
        return chatLanguageModel.chat(prompt);
    }

}
