package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by baizongjie on 2017/5/4.
 */
@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;


    public boolean set(String key, Object value){
        boolean result = false;
        try{
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public Object get(String key){
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }


}
