package com.lfc.wechat.splash;

import android.content.Intent;

import com.lfc.wechat.MainActivity;
import com.lfc.wechat.R;
import com.lfc.wechat.base.BaseActivity;
import com.lfc.wechat.base.BaseMVPActivity;
import com.lfc.wechat.base.IBaseView;
import com.lfc.wechat.login.LoginActivity;

import cn.bmob.v3.Bmob;

public class SplashActivity extends BaseMVPActivity<SplashContract.Presenter>
        implements SplashContract.View {

    private static final String BMOB_KEY = "ba9f28a4d7d0230a3f0cadae0fd069b6";

    @Override
    protected int getContentView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        Bmob.initialize(this, BMOB_KEY);
    }

    @Override
    public SplashContract.Presenter getPresenter() {
        return new SplashPresenter(this, this);
    }

    @Override
    public void startLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void startMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
