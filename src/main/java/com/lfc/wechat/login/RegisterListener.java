package com.lfc.wechat.login;

import com.lfc.wechat.entity.Account;

/**
 * Created by LittleFogCat on 2017/8/31.
 */

public interface RegisterListener {
    void onRegisterSuccess(Account account);

    void onRegisterFailure(Throwable e);
}
