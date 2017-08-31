package com.lfc.wechat.model.login;

import com.lfc.wechat.entity.Account;
import com.lfc.wechat.login.LoginListener;
import com.lfc.wechat.login.RegisterListener;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public class FakeLoginDataSource implements LoginDataSource {
    @Override
    public void login(String username, String password, LoginListener loginListener) {
        loginListener.onLoginSuccess();
    }

    @Override
    public void register(String username, String password, RegisterListener registerListener) {
        Account account = new Account();
        account.setUsername("bobbie");
        account.setPassword("bobbie123");
        account.setObjectId("123456789");
        registerListener.onRegisterSuccess(account);
    }

}
