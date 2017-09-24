package com.lfc.wechat.login;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lfc.wechat.R;
import com.lfc.wechat.base.BaseFragment;
import com.lfc.wechat.base.IBasePresenter;
import com.lfc.wechat.utils.CommonUtils;

import butterknife.BindView;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public class UnLogFragment extends BaseFragment {
    @BindView(R.id.btnLogin)
    TextView mBtnLogin;
    @BindView(R.id.btnReg)
    TextView mBtnReg;
    @BindView(R.id.btnLanguage)
    TextView mLanguage;
    @BindView(R.id.bg)
    ImageView mBackground;

    public static UnLogFragment newInstance() {

        Bundle args = new Bundle();

        UnLogFragment fragment = new UnLogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public IBasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getContentView() {
        return R.layout.unlog_fragment;
    }

    @Override
    public void initView() {
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UnLogFragment.this.startLoginFragment();
            }
        });
        mBtnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegisterFragment();
            }
        });
    }

    private void startLoginFragment() {
        LoginFragment loginFragment = LoginFragment.newInstance();
        CommonUtils.addFragment(getFragmentManager(), loginFragment, R.id.frame_content);
    }

    private void startRegisterFragment() {
        RegisterFragment registerFragment = RegisterFragment.newInstance();
        CommonUtils.addFragment(getFragmentManager(), registerFragment, R.id.frame_content);
    }
}
