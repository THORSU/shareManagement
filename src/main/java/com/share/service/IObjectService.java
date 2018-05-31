package com.share.service;

import com.share.pojo.ObjectInfo;
import com.share.pojo.Object_1;

import java.util.List;

/**
 * @Author: QuincySu
 * @Date: 2018/4/23
 */
public interface IObjectService {
    /**
     * 添加商品
     * @param object_1
     * @return
     */
    public Integer addObject(Object_1 object_1);

    /**
     * 查找商品
     * @param code
     * @return
     */
    public Object_1 getObject(String code);

    /**
     * 用商品名查找商品
     *
     * @param objectName
     * @return
     */
    public Object_1 getObjectFromName(String objectName);

    /**
     * 批量插入子商品
     *
     * @param objectInfos
     * @return
     */
    public int insertSubObject(List<ObjectInfo> objectInfos);
}
