package com.lfc.wechat.login;

import android.util.Log;

import com.lfc.wechat.base.BasePresenter;
import com.lfc.wechat.model.login.LoginRepository;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {
    private static final String TAG = "LoginPresenter";
    private LoginRepository mLoginRepository = null;

    protected LoginPresenter(LoginContract.View view, LoginRepository loginRepository) {
        super(view);
        mLoginRepository = loginRepository;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void login(String username, String password, LoginListener loginListener) {
        mLoginRepository.login(username, password, loginListener);
    }

    @Override
    public void login(String username, String password) {
        Log.d(TAG, "login: 开始登录");
        login(username, password, new LoginListener() {
            @Override
            public void onLoginSuccess() {
                mView.onLoginSuccess();
            }

            @Override
            public void onLoginFailed(String message) {
                Log.w(TAG, "onLoginFailed: " + message);
                mView.onLoginFailed();
            }
        });
    }

    @Override
    public void register(String username, String password) {

    }
}
