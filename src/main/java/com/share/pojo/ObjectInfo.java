package com.share.pojo;

import java.io.Serializable;

/**
 * Created by weixin on 18-4-21.
 */
public class ObjectInfo implements Serializable {

    private String id;//主键id

    private String objectId;//商品主表对应id

    private String code;//子商品序列号

    private String password;//子商品密码

    private String condition;//是否可用（0好1坏）

    private String remark;//商品备注

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ObjectInfo{" +
                "id=" + id +
                ", objectId=" + objectId +
                ", code='" + code + '\'' +
                ", password='" + password + '\'' +
                ", condition='" + condition + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
