package com.share.pojo;

/**
 * Created by weixin on 17-7-31.
 */
public class User {
    //id
    private String uid;
    //用户名
    private String uname;
    //密码
    private String upwd;
    //昵称
    private String alias;
    //手机号
    private String umobile;
    //申请
    private String IDnumber;
    //钱包
    private double wallet;
    private String condition;


    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUmobile() {
        return umobile;
    }

    public void setUmobile(String umobile) {
        this.umobile = umobile;
    }

    public String getIDnumber() {
        return IDnumber;
    }

    public void setIDnumber(String IDnumber) {
        this.IDnumber = IDnumber;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet=wallet;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", alias='" + alias + '\'' +
                ", umobile='" + umobile + '\'' +
                ", IDnumber='" + IDnumber + '\'' +
                ", wallet=" + wallet +
                ", condition='" + condition + '\'' +
                '}';
    }
}
