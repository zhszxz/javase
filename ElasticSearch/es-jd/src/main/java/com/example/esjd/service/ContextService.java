package com.example.esjd.service;

import com.alibaba.fastjson2.JSON;
import com.example.esjd.common.ContentContext;
import com.example.esjd.entity.Content;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ContextService {

    @Autowired
    public RestHighLevelClient client;

    public boolean parse(String keyword) throws IOException {
        List<Content> goods = ContentContext.get(keyword);
        if (CollectionUtils.isEmpty(goods)) {
            return false;
        }
        BulkRequest request = new BulkRequest("jd_goods");
        request.timeout(new TimeValue(60, TimeUnit.SECONDS));
        for (Content good : goods) {
            String jsonStr = JSON.toJSONString(good);
            log.info(jsonStr);
            request.add(new IndexRequest().source(jsonStr, XContentType.JSON));
        }
        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        return !response.hasFailures();
    }

    public List<Map<String, Object>> search(String keyword, int pageNo, int pageSize) throws IOException {
        SearchRequest request = new SearchRequest("jd_goods");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.from((pageNo - 1) * pageSize);
        searchSourceBuilder.size(pageSize);
        TermQueryBuilder termedQuery = QueryBuilders.termQuery("title", keyword);
        searchSourceBuilder.query(termedQuery);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        request.source(searchSourceBuilder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        List<Map<String, Object>> collect = Arrays.stream(response.getHits().getHits()).map(hit -> hit.getSourceAsMap()).collect(Collectors.toList());
        return collect;
    }

    public List<Map<String, Object>> searchWithHighLight(String keyword, int pageNo, int pageSize) throws IOException {
        SearchRequest request = new SearchRequest("jd_goods");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.from((pageNo - 1) * pageSize);
        searchSourceBuilder.size(pageSize);
        TermQueryBuilder termedQuery = QueryBuilders.termQuery("title", keyword);
        searchSourceBuilder.query(termedQuery);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        request.source(searchSourceBuilder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        List<Map<String, Object>> collect = Arrays.stream(response.getHits().getHits()).map(hit -> hit.getSourceAsMap()).collect(Collectors.toList());
        return collect;
    }
}
