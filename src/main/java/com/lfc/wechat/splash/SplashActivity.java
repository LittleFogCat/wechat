package com.lfc.wechat.splash;

import android.content.Intent;

import com.lfc.wechat.MainActivity;
import com.lfc.wechat.R;
import com.lfc.wechat.base.BaseMVPActivity;
import com.lfc.wechat.login.LoginActivity;
import com.lfc.wechat.data.login.LoginRepository;

import cn.bmob.v3.Bmob;

public class SplashActivity extends BaseMVPActivity<SplashContract.Presenter>
        implements SplashContract.View {

    private static final String BMOB_KEY = "ba9f28a4d7d0230a3f0cadae0fd069b6";
    private long startTime = 0;

    @Override
    protected int getContentView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        Bmob.initialize(this, BMOB_KEY);
        startTime = System.currentTimeMillis();
    }

    @Override
    public SplashContract.Presenter getPresenter() {
        return new SplashPresenter(this, this, new LoginRepository());
    }

    @Override
    public void startLoginActivity() {
        if (System.currentTimeMillis() - startTime < 3000) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
        }
    }

    @Override
    public void startMainActivity() {
        if (System.currentTimeMillis() - startTime < 3000) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } else {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }
    }
}
