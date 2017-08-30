package com.lfc.wechat.base;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter {

    protected V mView;

    protected BasePresenter(V view) {
        mView = view;
    }

    @Override
    public void unsubscribe() {

    }
}
