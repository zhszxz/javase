package com.example.esapi;

import com.example.esapi.entity.Human;
import com.example.esapi.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class EsApiDemoApplicationTests {

    @Autowired
    private RestHighLevelClient client;

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 创建索引
     * @throws IOException
     */
    @Test
    void testCreateIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("test_index");
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    /**
     * 判断索引是否存在
     * @throws IOException
     */
    @Test
    void testExistIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("test_index");
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    /**
     * 删除索引
     * @throws IOException
     */
    @Test
    void testDeleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("test_index");
        AcknowledgedResponse response = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());
    }

    /**
     * 添加文档
     * @throws IOException
     */
    @Test
    void testAddDocument() throws IOException {
        User user = new User("拜登", 10);
        IndexRequest request = new IndexRequest("test_index").id("1").source(objectMapper.writeValueAsString(user), XContentType.JSON);
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    /**
     * 判断文档是否存在
     * @throws IOException
     */
    @Test
    void testDocExist() throws IOException {
        GetRequest request = new GetRequest("test_index", "1");
        boolean exists = client.exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    /**
     * 查询文档
     * @throws IOException
     */
    @Test
    void testGetDocument() throws IOException {
        GetRequest request = new GetRequest("test_index", "1");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        System.out.println(response);
        System.out.println(response.getSourceAsString());
    }

    /**
     * 更新文档
     * @throws IOException
     */
    @Test
    void testUpdateDocument() throws IOException {
        UpdateRequest request = new UpdateRequest("test_index", "1");
        request.timeout("1s");
        User user = new User("老毕登", 100);
        request.doc(objectMapper.writeValueAsString(user), XContentType.JSON);
        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    /**
     * 删除文档
     * @throws IOException
     */
    @Test
    void testDeleteDocument() throws IOException {
        DeleteRequest request = new DeleteRequest("test_index", "1");
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    /**
     * 批量操作
     * @throws IOException
     */
    @Test
    void testBulk() throws IOException {
        BulkRequest request = new BulkRequest("index1");
        request.add(new IndexRequest("index1").id("5").source(objectMapper.writeValueAsString(new Human("杜鲁门", 88, 1, "美国总统", Arrays.asList("冷战", "马歇尔计划", "原子弹"))), XContentType.JSON))
                .add(new IndexRequest("index1").id("6").source(objectMapper.writeValueAsString(new Human("特朗普", 70, 1, "共产党特工川建国", Arrays.asList("贸易战", "懂王", "红领巾"))), XContentType.JSON));
        BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.status());
    }

    /**
     * 搜索文档
     * @throws IOException
     */
    @Test
    void testSearch() throws IOException {
        SearchRequest request = new SearchRequest("index1");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.timeout(new TimeValue(10, TimeUnit.SECONDS));
        searchSourceBuilder.query(QueryBuilders.matchQuery("name", "杜鲁门"));
        request.source(searchSourceBuilder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(objectMapper.writeValueAsString(hits));
        for (SearchHit hit : hits.getHits()) {
            System.out.println(hit.getSourceAsString());
        }
    }

}
