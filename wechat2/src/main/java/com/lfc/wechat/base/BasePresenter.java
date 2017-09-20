package com.lfc.wechat.base;

import android.content.Context;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter {

    protected V mView;
    protected Context mContext;
    protected CompositeSubscription mSubscriptions = new CompositeSubscription();

    public BasePresenter(Context context, V view) {
        mContext = context;
        mView = view;
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.unsubscribe();
    }
}
