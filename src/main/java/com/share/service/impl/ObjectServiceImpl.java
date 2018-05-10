package com.share.service.impl;

import com.share.mapper.ObjectMapper;
import com.share.pojo.Object_1;
import com.share.service.IObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: QuincySu
 * @Date: 2018/4/23
 */
@Service
public class ObjectServiceImpl implements IObjectService{

    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public Integer addObject(Object_1 object_1) {
        return objectMapper.addObject(object_1);
    }

    @Override
    public Object_1 getObject(String code) {
        return objectMapper.getObject(code);
    }
}
