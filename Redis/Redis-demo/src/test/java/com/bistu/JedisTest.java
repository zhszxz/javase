package com.bistu;

import com.bistu.Jedis.JedisFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setUp() {
        /*jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("739627");*/
        jedis=JedisFactory.getJedis();
        jedis.select(0);
    }

    //操作String类型数据
    @Test
    public void testString() {
        String result = jedis.set("name", "废物刀");
        System.out.println("result = " + result);
        String name = jedis.get("name");
        System.out.println("name = " + name);
    }

    //操作hash类型数据
    @Test
    public void testHash() {
        jedis.hset("user:1","name","zhangsan");
        jedis.hset("user:1","age","23");
        Map<String, String> map = jedis.hgetAll("user:1");
        System.out.println(map);
    }

    @AfterEach
    void tearDown() {
        if (jedis != null) {
            jedis.close();
            ;
        }
    }
}
