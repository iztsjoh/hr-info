package com.ibiz.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisAgent {

    @Autowired
    StringRedisTemplate redisTemplate;

    public String getSessionKey() {
        ValueOperations<String, String>  valueOperations = redisTemplate.opsForValue();

        return valueOperations.get("client_id");
    }

    public String getValue(String key) {
        ValueOperations<String, String>  valueOperations = redisTemplate.opsForValue();

        return valueOperations.get(key);
    }

}
