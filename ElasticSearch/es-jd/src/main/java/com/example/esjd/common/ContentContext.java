package com.example.esjd.common;

import com.example.esjd.entity.Content;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class ContentContext {
    private static HashMap<String, List<Content>> goodsMap = new HashMap<>();

    public static List<Content> get(String keyWord) {
        return goodsMap.get(keyWord);
    }

    public static void set(String keyWord, List<Content> contentList) {
        goodsMap.put(keyWord, contentList);
    }

    public static void remove(String keyWord) {
        goodsMap.remove(keyWord);
    }

    public static void clear() {
        goodsMap.clear();
    }
}
