package com.kangkang.api.service;

/**
 * Created by liudo on 2017/4/6.
 */
public interface RedisService {
    /**
     * 添加元素
     * @param key
     * @param value
     * @param minute
     */
    <K, V> void add(K key, V value, int minute);



    /**
     * 获取元素根据key
     * @param key
     * @return
     */
   <K,V> V get(K key);

    /**
     * 删除key
     * @param key
     */
   <K> void del(final K key);
}
