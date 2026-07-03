package com.example.demo5.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "openai.embeddingmodel")
public class EmbeddingModelProperties {
    private String baseurl;
    private String apikey;
    private String modelname;
}
