package com.example.demo5.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "milvus")
public class MilvusProperties {
    private String host;
    private int port;
    private String collectionname;
}
