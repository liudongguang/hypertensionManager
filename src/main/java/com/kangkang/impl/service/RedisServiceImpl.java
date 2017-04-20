package com.kangkang.impl.service;


import com.kangkang.api.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by liudo on 2017/4/6.
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public <K, V> void add(K key, V value, int minute) {
        if (key == null) {
            return;
        }
        ValueOperations<K, V> valueops = redisTemplate.opsForValue();
        valueops.set(key, value, minute, TimeUnit.MINUTES);
    }

    @Override
    public <K, V> V get(K key) {
        if (key == null) {
            return null;
        }
        ValueOperations<K, V> valueops = redisTemplate.opsForValue();
        V val = valueops.get(key);
        return val;
    }

    @Override
    public <K> void del(K key) {
        if (key == null) {
            return;
        }
        redisTemplate.delete(key);
    }
}
