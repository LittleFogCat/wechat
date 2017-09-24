package com.lfc.wechat.data.login;

import com.lfc.wechat.login.LoginListener;
import com.lfc.wechat.login.RegisterListener;
import com.lfc.wechat.data.DataSource;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public interface LoginDataSource extends DataSource {
    void login(String username, String password, LoginListener loginListener);

    void register(String username, String password, RegisterListener registerListener);
}
