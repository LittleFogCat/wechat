package com.lfc.wechat.splash;

import android.content.Context;
import android.text.TextUtils;

import com.lfc.wechat.base.BasePresenter;
import com.lfc.wechat.utils.SpUtils;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public class SplashPresenter extends BasePresenter<SplashContract.View>
        implements SplashContract.Presenter {
    private Context mContext;

    SplashPresenter(Context context, SplashContract.View view) {
        super(view);
        mContext = context;
    }

    @Override
    public void autoLogin() {
        mView.startMainActivity();
    }

    @Override
    public void readLoginInfo() {
        String usn = SpUtils.readString(mContext, SpUtils.USERNAME);
        String pwd = SpUtils.readString(mContext, SpUtils.PASSWORD);
        if (!TextUtils.isEmpty(usn) && !TextUtils.isEmpty(pwd)) {
            autoLogin();
        } else {
            mView.startLoginActivity();
        }
    }

    @Override
    public void subscribe() {
        readLoginInfo();
    }
}
