package com.lfc.wechat.entity;

/**
 * Created by 47510 on 2017/8/23.
 */

public class User {
    private String username;
    private String nickname;
    private String avatarUrl;
    private String area;

    public User() {
    }

    public User(String username, String nickname, String avatarUrl, String area) {
        this.username = username;
        this.nickname = nickname;
        this.avatarUrl = avatarUrl;
        this.area = area;
    }

    public User username(String username) {
        this.username = username;
        return this;
    }

    public User nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public User avatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    public User area(String area) {
        this.area = area;
        return this;
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
