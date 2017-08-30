package com.lfc.wechat.login;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public interface LoginListener {
    void onLoginSuccess();

    void onLoginFailed(String message);
}
