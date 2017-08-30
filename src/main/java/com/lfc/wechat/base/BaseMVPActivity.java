package com.lfc.wechat.base;

import android.os.Bundle;
import android.util.Log;

import com.lfc.wechat.application.LutilApplication;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;

/**
 * Created by LittleFogCat on 2017/8/24.
 * Activity基础类
 */

public abstract class BaseMVPActivity<P extends IBasePresenter> extends AutoLayoutActivity
        implements IBaseView<P> {
    private static final String TAG = "BaseActivity";
    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ((LutilApplication) getApplication()).addActivity(this);
        Log.d(TAG, "onCreate: " + getClass().getSimpleName());
        ButterKnife.bind(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        mPresenter = getPresenter();
        initView();
    }

    /**
     * Activity布局id
     */
    protected abstract int getContentView();

    /**
     * 初始化布局
     */
    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((LutilApplication) getApplication()).removeActivity(this);
    }

    protected void exit() {
        ((LutilApplication) getApplication()).finishAll();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }
}
