package com.lfc.wechat.base;

import android.os.Bundle;
import android.util.Log;

import com.example.ui.autolayout.AutoLayoutActivity;
import com.lfc.wechat.application.LutilApplication;

import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by LittleFogCat on 2017/8/24.
 * Activity基础类
 */

public abstract class BaseActivity extends AutoLayoutActivity{
    private static final String TAG = "BaseActivity";
    private SweetAlertDialog mProgressDialog;

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

    public void exit() {
        ((LutilApplication) getApplication()).exit();
    }

    public void finishAll() {
        ((LutilApplication) getApplication()).finishAll();
    }

}
