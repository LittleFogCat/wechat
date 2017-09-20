package com.lfc.wechat.splash;

import com.lfc.wechat.base.IBasePresenter;
import com.lfc.wechat.base.IBaseView;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public interface SplashContract {
    interface View extends IBaseView<Presenter> {
        void startLoginActivity();

        void startMainActivity();
    }

    interface Presenter extends IBasePresenter {
        void readLoginInfo();

        void autoLogin(String username, String password);
    }
}
