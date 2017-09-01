package com.lfc.wechat.main.settings;

import com.lfc.wechat.base.IBasePresenter;
import com.lfc.wechat.base.IBaseView;

/**
 * Created by LittleFogCat on 2017/9/1.
 */

public interface SettingsContract {
    interface View extends IBaseView<Presenter> {
        void onLogoutSuccess();
    }

    interface Presenter extends IBasePresenter {
        void logout();
    }
}
