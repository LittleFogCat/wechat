package com.lfc.wechat.main.chatlist;

import android.content.Context;

import com.lfc.wechat.base.BasePresenter;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public class ChatListPresenter extends BasePresenter<ChatListContract.View>
        implements ChatListContract.Presenter {
    protected ChatListPresenter(Context context, ChatListContract.View view) {
        super(context, view);
    }

    @Override
    public void subscribe() {

    }
}
