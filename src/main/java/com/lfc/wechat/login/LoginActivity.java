package com.lfc.wechat.login;

import android.content.Intent;
import android.view.Gravity;
import android.widget.Toast;

import com.lfc.wechat.MainActivity;
import com.lfc.wechat.R;
import com.lfc.wechat.base.BaseMVPActivity;
import com.lfc.wechat.model.login.LoginRepository;
import com.lfc.wechat.utils.CommonUtils;

public class LoginActivity extends BaseMVPActivity<LoginContract.Presenter>
        implements LoginContract.View {

    @Override
    protected int getContentView() {
        return R.layout.login_activity;
    }

    @Override
    protected void initView() {
        UnlogFragment unlogFragment = (UnlogFragment) getSupportFragmentManager().findFragmentById(R.id.frame_content);
        if (unlogFragment == null) {
            unlogFragment = UnlogFragment.newInstance();
        }
        CommonUtils.addFragment(this, unlogFragment, R.id.frame_content);
    }

    @Override
    public LoginContract.Presenter getPresenter() {
        return new LoginPresenter(this, new LoginRepository());
    }

    public void onLoginClick(String username, String password) {
        Toast.makeText(this, "正在登录", Toast.LENGTH_SHORT)
                .show();
        mPresenter.login(username, password);
    }

    @Override
    public void onLoginFailed() {
        Toast.makeText(this, "登录失败，请稍后重试", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
