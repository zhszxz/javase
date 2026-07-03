package com.bistu;

import com.bistu.redis.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Map;

@SpringBootTest
class RedisStringApplicationTests {

    //StringRedisTemplate key和value默认的序列化器都是String
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testString() {
        stringRedisTemplate.opsForValue().set("name", "初音未来");
        Object name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);
    }

    @Test
    void testObj() throws JsonProcessingException {
        //处理引用类型需要手动序列化与反序列化
        User user = new User("lisi", 24);
        String jsonString = objectMapper.writeValueAsString(user);
        stringRedisTemplate.opsForValue().set("user:2", jsonString);
        String jsonUser = stringRedisTemplate.opsForValue().get("user:2");
        user = objectMapper.readValue(jsonUser, User.class);
        System.out.println(user);
    }

    @Test
    void testhash() {
        stringRedisTemplate.opsForHash().put("user:3", "name", "虎哥");
        stringRedisTemplate.opsForHash().put("user:3", "age", "21");
        Map<Object, Object> map = stringRedisTemplate.opsForHash().entries("user:3");
        System.out.println(map);
    }
}
