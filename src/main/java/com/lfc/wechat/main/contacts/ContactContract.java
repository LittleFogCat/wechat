package com.lfc.wechat.main.contacts;

import com.lfc.wechat.base.IBasePresenter;
import com.lfc.wechat.base.IBaseView;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public interface ContactContract {
    interface View extends IBaseView<Presenter> {
    }

    interface Presenter extends IBasePresenter {
    }
}
