package com.lfc.wechat.data.message;

import com.lfc.wechat.entity.Chat;
import com.lfc.wechat.global.GlobalConstant;

import java.util.List;

/**
 * Created by 47510 on 2017/8/23.
 */

public class MessageRepository implements MessageDataSource {

    private MessageDataSource mRepository;

    public MessageRepository() {
        if (GlobalConstant.USE_REMOTE_REPOSITORY) {
            mRepository = new MessageRemoteDataSource();
        } else {
            mRepository = new FakeMessageDataSource();
        }
    }

    @Override
    public List<Chat> getChatList() {
        return mRepository.getChatList();
    }
}
