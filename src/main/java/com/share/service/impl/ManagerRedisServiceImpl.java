package com.share.service.impl;

import com.share.pojo.Manager;
import com.share.service.IManagerRedisService;
import org.springframework.beans.factory.annotation.Autowired;
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
        ValueOperations<String, Manager> valueops = redisTemplate.opsForValue();
        valueops.set(manager.getMname(), manager);
        colls.add(manager.getMname());
    }

    @Override
    public Manager getManger(String username) {
        ValueOperations<String, Manager> valueOperations = redisTemplate.opsForValue();
        Manager manager = valueOperations.get(username);
        return manager;
    }
}
