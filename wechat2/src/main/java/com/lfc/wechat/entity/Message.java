package com.lfc.wechat.entity;

/**
 * Created by 47510 on 2017/8/23.
 * 一条消息
 */
public class Message {
    private User fromUser;
    private User toUser;
    private String content;
    private long sendTime;
    private long receiveTime;


    public Message() {
    }

    public Message(User fromUser, User toUser, String content, long sendTime, long receiveTime) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.content = content;
        this.sendTime = sendTime;
        this.receiveTime = receiveTime;
    }

    public Message fromUser(User user) {
        fromUser = user;
        return this;
    }

    public Message toUser(User user) {
        toUser = user;
        return this;
    }

    public Message content(String content) {
        this.content = content;
        return this;
    }

    public Message sendTime(long sendTime) {
        this.sendTime = sendTime;
        return this;
    }

    public Message receiveTime(long receiveTime) {
        this.receiveTime = receiveTime;
        return this;
    }


    public User getFromUser() {
        return fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public String getContent() {
        return content;
    }

    public long getSendTime() {
        return sendTime;
    }

    public long getReceiveTime() {
        return receiveTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "fromUser=" + fromUser +
                ", toUser=" + toUser +
                ", content='" + content + '\'' +
                ", sendTime=" + sendTime +
                ", receiveTime=" + receiveTime +
                '}';
    }
}
