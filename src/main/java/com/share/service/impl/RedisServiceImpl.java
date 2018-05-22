package com.share.service.impl;

import com.alibaba.fastjson.JSON;
import com.share.pojo.Manager;
import com.share.pojo.Merchant;
import com.share.pojo.Object_1;
import com.share.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author: QuincySu
 * @Date: 2018/5/7
 */
@Service
public class RedisServiceImpl implements IRedisService {
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
        Manager manager = JSON.parseObject(res, Manager.class);
        return manager;
    }

    @Override
    public void addMerchant(Merchant merchant) {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        hashOperations.put("merchant", merchant.getMerchantName(), JSON.toJSONString(merchant));
    }

    @Override
    public Merchant getMerchant(String merchantName) {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        String res = hashOperations.get("merchant", merchantName);
        Merchant merchant = JSON.parseObject(res, Merchant.class);
        return merchant;
    }

    @Override
    public void addObject(Object_1 object_1) {
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        hashOperations.put("shareObject", "shareObject" + object_1.getObjectCode(), JSON.toJSONString(object_1));
    }
}
