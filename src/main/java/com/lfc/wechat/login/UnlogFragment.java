package com.lfc.wechat.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.lfc.wechat.R;
import com.lfc.wechat.base.BaseFragment;
import com.lfc.wechat.base.IBasePresenter;
import com.lfc.wechat.utils.CommonUtils;

import butterknife.BindView;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public class UnlogFragment extends BaseFragment {
    @BindView(R.id.btnLogin)
    TextView mBtnLogin;
    @BindView(R.id.btnReg)
    TextView mBtnReg;
    @BindView(R.id.btnLanguage)
    TextView mLanguage;

    public static UnlogFragment newInstance() {

        Bundle args = new Bundle();

        UnlogFragment fragment = new UnlogFragment();
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
                UnlogFragment.this.startLoginFragment();
            }
        });
    }

    private void startLoginFragment() {
        LoginFragment loginFragment = LoginFragment.newInstance();
        CommonUtils.addFragment(((AppCompatActivity) getActivity()), loginFragment, R.id.frame_content);
    }
}
