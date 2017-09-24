package com.lfc.wechat.splash;

import android.content.Context;
import android.text.TextUtils;

import com.lfc.wechat.base.BasePresenter;
import com.lfc.wechat.login.LoginListener;
import com.lfc.wechat.data.login.LoginRepository;
import com.lfc.wechat.utils.SpUtils;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public class SplashPresenter extends BasePresenter<SplashContract.View>
        implements SplashContract.Presenter {
    private LoginRepository mLoginRepository;

    SplashPresenter(Context context, SplashContract.View view, LoginRepository loginRepository) {
        super(context,view);
        mLoginRepository = loginRepository;
    }

    @Override
    public void autoLogin(String username, String password) {
        mLoginRepository.login(username, password, new LoginListener() {
            @Override
            public void onLoginSuccess() {
                mView.startMainActivity();
            }

            @Override
            public void onLoginFailed(Throwable e) {
                mView.startLoginActivity();
            }
        });
    }

    @Override
    public void readLoginInfo() {
        String usn = SpUtils.readString(mContext, SpUtils.USERNAME);
        String pwd = SpUtils.readString(mContext, SpUtils.PASSWORD);
        if (!TextUtils.isEmpty(usn) && !TextUtils.isEmpty(pwd)) {
            autoLogin(usn, pwd);
        } else {
            mView.startLoginActivity();
        }
    }

    @Override
    public void subscribe() {
        readLoginInfo();
    }
}
