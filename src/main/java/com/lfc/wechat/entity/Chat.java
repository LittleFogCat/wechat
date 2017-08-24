package com.lfc.wechat.entity;

import java.util.List;

/**
 * Created by 47510 on 2017/8/23.
 * 一个聊天
 */

public class Chat {
    private User fromUser;
    private List<Message> messageList;

    public Chat(User fromUser, List<Message> messageList) {
        this.fromUser = fromUser;
        this.messageList = messageList;
    }

    public User getFromUser() {
        return fromUser;
    }

    public List<Message> getMessageList() {
        return messageList;
    }
}
