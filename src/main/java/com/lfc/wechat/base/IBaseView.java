package com.lfc.wechat.base;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public interface IBaseView<P extends IBasePresenter> {
    P getPresenter();
}
