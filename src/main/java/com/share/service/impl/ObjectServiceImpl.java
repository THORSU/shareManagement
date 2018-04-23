package com.share.service.impl;

import com.share.mapper.ObjectMapper;
import com.share.pojo.Object_1;
import com.share.service.IObjectService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: QuincySu
 * @Date: 2018/4/23
 */
public class ObjectServiceImpl implements IObjectService{

    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public Object_1 addObject(Object_1 object_1) {
        return objectMapper.addObject(object_1);
    }
}
