package com.share.service;

import com.share.pojo.Manager;
import com.share.pojo.Object_1;

/**
 * @Author: QuincySu
 * @Date: 2018/5/7
 */
public interface IRedisService {
    /**
     * 增加管理员
     * @param manager
     */
    void addManager(Manager manager);

    /**
     * 获取redis的信息
     *
     * @param username
     * @return
     */
    Manager getManger(String username);

    void addObject(Object_1 object_1);
}
