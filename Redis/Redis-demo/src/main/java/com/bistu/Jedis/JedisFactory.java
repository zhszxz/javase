package com.bistu.Jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisFactory {
    private static final redis.clients.jedis.JedisPool jedisPool;

    static {
        //连接池配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(8);//最大连接数
        jedisPoolConfig.setMaxIdle(8);//最大空闲连接数
        jedisPoolConfig.setMinIdle(1);//最小空闲连接数
        jedisPoolConfig.setMaxWaitMillis(1000);//最大等待时间
        jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379, 1000, "739627");
    }

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
