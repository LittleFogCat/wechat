package com.lfc.wechat.data.login;

import com.lfc.wechat.global.GlobalConstant;
import com.lfc.wechat.login.LoginListener;
import com.lfc.wechat.login.RegisterListener;
import com.lfc.wechat.data.BaseRepository;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public class LoginRepository extends BaseRepository
        implements LoginDataSource {
    private LoginDataSource mDataSource;

    public LoginRepository() {
        if (GlobalConstant.USE_REMOTE_REPOSITORY) {
            mDataSource = new LoginRemoteDataSource();
        } else {
            mDataSource = new FakeLoginDataSource();
        }
    }

    @Override
    public void login(String username, String password, LoginListener loginListener) {
        mDataSource.login(username, password, loginListener);
    }

    @Override
    public void register(String username, String password, RegisterListener registerListener) {
        mDataSource.register(username, password, registerListener);
    }
}
