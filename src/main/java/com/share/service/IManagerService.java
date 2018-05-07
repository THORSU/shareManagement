package com.share.service;

import com.share.pojo.Manager;

/**
 * @Author: QuincySu
 * @Date: 2018/4/23
 */
public interface IManagerService {
    /**
     * 管理员登录
     * @param manager
     * @return
     */
    public Manager login(Manager manager);

    /**
     * 管理员注册
     * @param manager
     * @return
     */
    public Integer signUp(Manager manager);

    /**
     * 查看是否注册
     * @param manager
     * @return
     */
    public Manager getManager(Manager manager);
}
