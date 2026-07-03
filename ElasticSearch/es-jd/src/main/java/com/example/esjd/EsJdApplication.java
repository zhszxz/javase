package com.example.esjd;

import com.example.esjd.common.ContentContext;
import com.example.esjd.entity.Content;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.core.type.TypeReference;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@SpringBootApplication
public class EsJdApplication implements CommandLineRunner {

    @Autowired
    private ObjectMapper mapper;

    public static void main(String[] args) {
        SpringApplication.run(EsJdApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            // 获取 resources/goods 目录
            ClassLoader classLoader = EsJdApplication.class.getClassLoader();
            URL url = classLoader.getResource("goods");
            if (url == null) {
                throw new RuntimeException("未找到 resources/goods 目录");
            }

            File goodsDir = new File(url.getPath());
            if (!goodsDir.exists() || !goodsDir.isDirectory()) {
                throw new RuntimeException("goods 不是有效的目录");
            }

            // 遍历目录下的所有 .json 文件
            File[] files = goodsDir.listFiles((dir, name) -> name.endsWith(".json"));
            if (files == null || files.length == 0) {
                throw new RuntimeException("goods 目录下没有任何 JSON 文件");
            }

            for (File file : files) {
                String fileName = file.getName().replace(".json", "");
                List<Content> contentList = mapper.readValue(file, new TypeReference<List<Content>>() {
                });
                ContentContext.set(fileName, contentList);
            }

        } catch (IOException e) {
            throw new RuntimeException("读取 JSON 文件时出错: " + e.getMessage(), e);
        }
    }
}
