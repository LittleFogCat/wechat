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

    public Message(User fromUser, User toUser, String content, long sendTime, long receiveTime) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.content = content;
        this.sendTime = sendTime;
        this.receiveTime = receiveTime;
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
}
