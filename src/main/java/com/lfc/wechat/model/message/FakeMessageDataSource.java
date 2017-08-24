package com.lfc.wechat.model.message;

import com.lfc.wechat.entity.Chat;

import java.util.List;

/**
 * Created by 47510 on 2017/8/23.
 */

public class FakeMessageDataSource implements MessageDataSource {
    @Override
    public List<Chat> getChatList() {
        return FakeMessageData.getFakeChatList();
    }
}
