package com.lfc.wechat.login;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.lfc.wechat.MainActivity;
import com.lfc.wechat.R;
import com.lfc.wechat.base.BaseMVPActivity;
import com.lfc.wechat.entity.Account;
import com.lfc.wechat.model.login.LoginRepository;
import com.lfc.wechat.utils.CommonUtils;
import com.lfc.wechat.utils.SpUtils;

public class LoginActivity extends BaseMVPActivity<LoginContract.Presenter>
        implements LoginContract.View {

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
        CommonUtils.showToast(this, getString(R.string.logging));
        mPresenter.login(username, password);
    }

    @Override
    public void onLoginFailed() {
        CommonUtils.showToast(this, getString(R.string.login_failed_please_retry));
    }

    @Override
    public void onLoginSuccess() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    public void onRegisterClicked(String username, String password) {
        mPresenter.register(username, password);
    }

    @Override
    public void onRegisterSuccess(Account account) {
        SpUtils.saveString(this, "account", account.toString());
        FragmentManager manager = getSupportFragmentManager();
        CommonUtils.removeFragment(manager, RegisterFragment.class);
        CommonUtils.showToast(getApplicationContext(), getString(R.string.register_success));
    }

    @Override
    public void onRegisterFailure(Throwable e) {
        CommonUtils.showToast(getApplicationContext(), e.getMessage());
    }
}
