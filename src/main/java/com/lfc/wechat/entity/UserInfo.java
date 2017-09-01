package com.lfc.wechat.entity;

import cn.bmob.v3.BmobObject;

/**
 * Created by LittleFogCat on 2017/8/31.
 */

public class UserInfo extends BmobObject {
    private String username;
    private String wxNum;
    private String nickname;
    private String avatarUrl;
    private String qrCode;

    public String getQrCode() {
        return qrCode;
    }

    public UserInfo setQrCode(String qrCode) {
        this.qrCode = qrCode;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWxNum() {
        return wxNum;
    }

    public UserInfo setWxNum(String wxNum) {
        this.wxNum = wxNum;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public UserInfo setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public UserInfo setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }
}
