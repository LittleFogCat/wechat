package com.lfc.wechat.login;

import javax.security.auth.login.LoginException;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public interface LoginListener {
    void onLoginSuccess();

    void onLoginFailed(Throwable e);
}
