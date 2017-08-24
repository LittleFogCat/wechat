package com.lfc.wechat.model.message;

import com.lfc.wechat.entity.Chat;
import com.lfc.wechat.model.FakeDataCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 47510 on 2017/8/23.
 */

public class FakeMessageData {
    public static List<Chat> getFakeChatList() {
        List<Chat> chatList = new ArrayList<>();
        for (int i = 0; i < 19; i++) {
            chatList.add(FakeDataCreator.createFakeChat());
        }
        return chatList;
    }
}
