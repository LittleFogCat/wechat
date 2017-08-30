package com.lfc.wechat.login;

import com.lfc.wechat.base.IBasePresenter;
import com.lfc.wechat.base.IBaseView;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public interface LoginContract {
    interface View extends IBaseView<Presenter> {
        void onLoginSuccess();

        void onLoginFailed();
    }

    interface Presenter extends IBasePresenter {
        void login(String username, String password, LoginListener loginListener);

        void login(String username, String password);

        void register(String username, String password);
    }
}
