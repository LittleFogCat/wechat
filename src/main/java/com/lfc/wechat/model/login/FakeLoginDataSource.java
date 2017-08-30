package com.lfc.wechat.model.login;

import com.lfc.wechat.login.LoginListener;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public class FakeLoginDataSource implements LoginDataSource {
    @Override
    public void login(String username, String password, LoginListener loginListener) {
        loginListener.onLoginSuccess();
    }

    @Override
    public void register(String username, String password) {

    }
}
