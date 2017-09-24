package com.lfc.wechat.main.contacts;

import android.content.Context;

import com.lfc.wechat.base.BasePresenter;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public class ContactPresenter extends BasePresenter<ContactContract.View>
        implements ContactContract.Presenter {
    protected ContactPresenter(Context context, ContactContract.View view) {
        super(context, view);
    }

    @Override
    public void subscribe() {

    }
}
