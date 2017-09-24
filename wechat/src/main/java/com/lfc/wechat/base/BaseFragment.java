package com.lfc.wechat.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lfc.wechat.R;
import com.lfc.wechat.utils.DialogUtils;

import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by 47510 on 2017/8/23.
 */

public abstract class BaseFragment<P extends IBasePresenter> extends Fragment
        implements IBaseView<P> {
    protected static final String TAG = "BaseFragment";
    protected P mPresenter;
    private SweetAlertDialog mProgressDialog = null;

    protected BaseFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentView(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public abstract int getContentView();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mPresenter = getPresenter();
        initView();
        if (mPresenter != null) mPresenter.subscribe();
    }

    public abstract void initView();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.unsubscribe();
    }

    public void showProgressDialog() {
        showProgressDialog(getString(R.string.please_wait));
    }

    public void dismissProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.cancel();
            mProgressDialog = null;
        }
    }

    @Override
    public void showProgressDialog(String msg) {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
        mProgressDialog = DialogUtils.showProgressDialog(getContext(), msg);
        mProgressDialog.show();
    }

    public void pop() {
        getFragmentManager().beginTransaction().remove(this).commit();
    }

    public BaseActivity getBaseActivity(){
        return (BaseActivity) getActivity();
    }
}
