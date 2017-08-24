package com.lfc.wechat.model.message;

import com.lfc.wechat.BuildConfig;
import com.lfc.wechat.entity.Chat;

import java.util.List;

/**
 * Created by 47510 on 2017/8/23.
 */

public class MessageRepository implements MessageDataSource {

    private MessageDataSource mRepository;

    public MessageRepository() {
        if (BuildConfig.DEBUG) {
            mRepository = new FakeMessageDataSource();
        } else {
            mRepository = new MessageRemoteDataSource();
        }
    }

    @Override
    public List<Chat> getChatList() {
        return mRepository.getChatList();
    }
}
