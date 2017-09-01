package com.lfc.wechat.login;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.lfc.wechat.MainActivity;
import com.lfc.wechat.R;
import com.lfc.wechat.base.BaseMVPActivity;
import com.lfc.wechat.entity.Account;
import com.lfc.wechat.data.login.LoginRepository;
import com.lfc.wechat.throwable.WrongUsernameOrPasswordException;
import com.lfc.wechat.utils.CommonUtils;
import com.lfc.wechat.utils.DialogUtils;
import com.lfc.wechat.utils.SpUtils;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class LoginActivity extends BaseMVPActivity<LoginContract.Presenter>
        implements LoginContract.View {
    private static final String TAG = "LoginActivity";

    @Override
    protected int getContentView() {
        return R.layout.login_activity;
    }

    @Override
    protected void initView() {
        UnLogFragment unLogFragment = (UnLogFragment) getSupportFragmentManager().findFragmentById(R.id.frame_content);
        if (unLogFragment == null) {
            unLogFragment = UnLogFragment.newInstance();
        }
        CommonUtils.addFragment(getSupportFragmentManager(), unLogFragment, R.id.frame_content);
    }

    @Override
    public LoginContract.Presenter getPresenter() {
        return new LoginPresenter(this, this, new LoginRepository());
    }

    public void onLoginClicked(String username, String password) {
        showProgressDialog(getString(R.string.logging));
        CommonUtils.showToast(this, getString(R.string.logging));
        mPresenter.login(username, password);
    }

    @Override
    public void onLoginFailed(Throwable e) {
        dismissProgressDialog();
        Log.w(TAG, "onLoginFailed: " + e.getMessage());
        if (e instanceof WrongUsernameOrPasswordException) {
            DialogUtils.showErrorDialog(this, "登录失败：" + getString(R.string.wrong_username_or_password));
        } else {
            DialogUtils.showErrorDialog(this, "登录失败：" + getString(R.string.login_failed_please_retry));
        }
    }

    @Override
    public void onLoginSuccess() {
        dismissProgressDialog();
        DialogUtils.showSuccessDialog(this, getString(R.string.login_success), new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    public void onRegisterClicked(String username, String password) {
        showProgressDialog(getString(R.string.registering));
        mPresenter.register(username, password);
    }

    @Override
    public void onRegisterSuccess(Account account) {
        dismissProgressDialog();
        SpUtils.saveString(this, "account", account.toString());
        FragmentManager manager = getSupportFragmentManager();
        CommonUtils.removeFragment(manager, RegisterFragment.class);
        CommonUtils.showToast(getApplicationContext(), getString(R.string.register_success));
    }

    @Override
    public void onRegisterFailure(Throwable e) {
        dismissProgressDialog();
        Log.w(TAG, "onRegisterFailure: " + e.getMessage());
        if (e instanceof WrongUsernameOrPasswordException) {
            CommonUtils.showToast(getApplicationContext(), getString(R.string.wrong_username_or_password));
        } else {
            CommonUtils.showToast(getApplicationContext(), getString(R.string.unknown_error));
        }
    }
}
