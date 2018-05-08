package com.share.service;

import com.share.pojo.Manager;

/**
 * @Author: QuincySu
 * @Date: 2018/5/7
 */
public interface IManagerRedisService {
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
}
