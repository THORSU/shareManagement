package com.share.service.impl;

import com.share.mapper.ManagerMapper;
import com.share.pojo.Manager;
import com.share.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: QuincySu
 * @Date: 2018/4/23
 */
@Service
public class ManagerServiceImpl implements IManagerService{
    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public Manager login(Manager manager) {
        return managerMapper.login(manager);
    }

    @Override
    public Integer signUp(Manager manager) {
        return managerMapper.signUp(manager);
    }
}
