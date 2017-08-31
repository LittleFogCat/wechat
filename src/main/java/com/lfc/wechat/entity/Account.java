package com.lfc.wechat.entity;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public class Account extends BmobObject implements Serializable {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public Account setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Account setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", objectId='" + getObjectId() + '\'' +
                '}';
    }
}
