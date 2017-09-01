package com.lfc.wechat.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.lfc.wechat.R;
import com.lfc.wechat.application.LutilApplication;
import com.lfc.wechat.utils.DialogUtils;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by LittleFogCat on 2017/8/24.
 * Activity基础类
 */

public abstract class BaseMVPActivity<P extends IBasePresenter> extends BaseActivity
        implements IBaseView<P> {
    private static final String TAG = "BaseActivity";
    protected P mPresenter;
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
        mPresenter = getPresenter();
        initView();
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

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View view = getCurrentFocus();
            if (isShouldHideInput(view, ev) && view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        return getWindow().superDispatchTouchEvent(ev) || onTouchEvent(ev);
    }

    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public void showProgressDialog(String msg) {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
        mProgressDialog = DialogUtils.showProgressDialog(this, msg);
        mProgressDialog.show();
    }

    public void dismissProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.cancel();
            mProgressDialog = null;
        }
    }

    @Override
    public void showProgressDialog() {
        showProgressDialog(getString(R.string.please_wait));
    }
}
