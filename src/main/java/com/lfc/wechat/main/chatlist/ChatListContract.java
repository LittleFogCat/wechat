package com.lfc.wechat.main.chatlist;

import com.lfc.wechat.base.IBasePresenter;
import com.lfc.wechat.base.IBaseView;

/**
 * Created by LittleFogCat on 2017/8/31.
 */

public interface ChatListContract {
    interface View extends IBaseView<Presenter> {
    }

    interface Presenter extends IBasePresenter {
    }
}
