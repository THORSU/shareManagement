package com.share.service.impl;

import com.alibaba.fastjson.JSON;
import com.share.pojo.Manager;
import com.share.service.IManagerRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author: QuincySu
 * @Date: 2018/5/7
 */
@Service
public class ManagerRedisServiceImpl implements IManagerRedisService {
    @Autowired
    private RedisTemplate redisTemplate;
    Collection<String> colls = new ArrayList<String>();

    @Override
    public void addManager(Manager manager) {
        //todo 改用hash类型
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        hashOperations.put("manager", manager.getMname(), JSON.toJSONString(manager));
    }

    @Override
    public Manager getManger(String username) {
        //todo hash
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        String res = hashOperations.get("manager", username);
        Manager manager=JSON.parseObject(res,Manager.class);
        return manager;
    }
}
