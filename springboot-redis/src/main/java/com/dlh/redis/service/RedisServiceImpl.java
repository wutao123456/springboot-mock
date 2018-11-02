package com.dlh.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/10/24 23:38
 */
@Component
public class RedisServiceImpl{

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存放实体对象,实体对象一定要实现序列化接口
     * @param key
     * @param value
     */
    public void putEntity(String key,Object value){
        if(StringUtils.isEmpty(key)){
            return;
        }

        ValueOperations operations = redisTemplate.opsForValue();
        operations.set(key,value);
    }

    public void put(String key,Object value,long expire){
        if(StringUtils.isEmpty(key)){
            return;
        }

        ValueOperations operations = redisTemplate.opsForValue();
        operations.set(key,value);
        if(expire > 0){
            redisTemplate.expire(key,expire, TimeUnit.SECONDS);
        }
    }

    public Object get(String key){
        ValueOperations operations = redisTemplate.opsForValue();
        return operations.get(key);
    }



    public void putSet(String key,Set<String> values){
        if(StringUtils.isEmpty(key) || values == null || values.isEmpty()){
            return;
        }

        SetOperations set = redisTemplate.opsForSet();
        set.add(key,values);
    }

    public Set getSets(String key){
        SetOperations set = redisTemplate.opsForSet();
        return set.members(key);
    }

    public void hmset(String name,Map<String,String> map){
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.putAll(name,map);
    }

    public Map<String,String> hgset(String name){
        HashOperations hashOperations = redisTemplate.opsForHash();
        return hashOperations.entries(name);
    }

    public void putList(String name,List<String> list){
        ListOperations operations = redisTemplate.opsForList();
        operations.leftPushAll(name,list);
    }

    public List<String> getLists(String name){
        ListOperations operations = redisTemplate.opsForList();
        long size = operations.size(name);
        List<String> list = operations.range(name,0,size);
        return list;
    }


}
