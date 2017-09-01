package com.lfc.wechat.login;

import android.content.Context;
import android.util.Log;

import com.lfc.wechat.base.BasePresenter;
import com.lfc.wechat.entity.Account;
import com.lfc.wechat.data.login.LoginRepository;
import com.lfc.wechat.utils.SpUtils;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {
    private static final String TAG = "LoginPresenter";
    private LoginRepository mLoginRepository = null;
    private Context mContext = null;

    protected LoginPresenter(Context context, LoginContract.View view, LoginRepository loginRepository) {
        super(context,view);
        mLoginRepository = loginRepository;
        mContext = context;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void login(String username, String password, LoginListener loginListener) {
        mLoginRepository.login(username, password, loginListener);
    }

    @Override
    public void login(final String username, final String password) {
        Log.d(TAG, "login: 开始登录");
        login(username, password, new LoginListener() {
            @Override
            public void onLoginSuccess() {
                mView.onLoginSuccess();
                SpUtils.saveString(mContext, "username", username);
                SpUtils.saveString(mContext, "password", password);
            }

            @Override
            public void onLoginFailed(Throwable e) {
                Log.w(TAG, "onLoginFailed: " + e.getMessage());
                mView.onLoginFailed(e);
            }
        });
    }

    @Override
    public void register(String username, String password) {
        Log.d(TAG, "register");
        mLoginRepository.register(username, password, new RegisterListener() {
            @Override
            public void onRegisterSuccess(Account account) {
                mView.onRegisterSuccess(account);
            }

            @Override
            public void onRegisterFailure(Throwable e) {
                mView.onRegisterFailure(e);
            }
        });
    }
}
