package com.lfc.wechat.entity;

/**
 * Created by 47510 on 2017/8/23.
 */

public class User {
    private String username;
    private String nickname;
    private String avatarUrl;
    private String area;

    public User(String username, String nickname, String avatarUrl, String area) {
        this.username = username;
        this.nickname = nickname;
        this.avatarUrl = avatarUrl;
        this.area = area;
    }

    public String getUsername() {
        return username;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getArea() {
        return area;
    }
}
