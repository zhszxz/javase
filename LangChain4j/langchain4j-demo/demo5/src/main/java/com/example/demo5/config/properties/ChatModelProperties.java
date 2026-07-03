package com.example.demo5.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "openai.chatmodel")
public class ChatModelProperties {
    private String baseurl;
    private String apikey;
    private String modelname;
    private double temperature;
}
