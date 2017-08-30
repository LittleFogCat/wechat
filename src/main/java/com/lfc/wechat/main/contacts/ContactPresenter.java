package com.lfc.wechat.main.contacts;

import com.lfc.wechat.base.BasePresenter;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public class ContactPresenter extends BasePresenter<ContactContract.View>
        implements ContactContract.Presenter {
    protected ContactPresenter(ContactContract.View view) {
        super(view);
    }

    @Override
    public void subscribe() {

    }
}
