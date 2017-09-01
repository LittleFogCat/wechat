package com.lfc.wechat.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lfc.wechat.R;
import com.lfc.wechat.base.BaseFragment;
import com.lfc.wechat.base.IBasePresenter;
import com.lfc.wechat.utils.CommonUtils;

import butterknife.BindView;

/**
 * Created by LittleFogCat on 2017/8/31.
 */

public class RegisterFragment extends BaseFragment {
    private static final String TAG = "RegisterFragment";
    @BindView(R.id.et_username)
    TextView mUsername;
    @BindView(R.id.et_password)
    TextView mPassword;
    @BindView(R.id.btn_register)
    TextView mRegister;
    @BindView(R.id.back)
    ImageView mBack;

    public static RegisterFragment newInstance() {
        Bundle args = new Bundle();
        RegisterFragment fragment = new RegisterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public IBasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getContentView() {
        return R.layout.register_fragment;
    }

    @Override
    public void initView() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: register");
                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();
                if (TextUtils.isEmpty(username)) {
                    CommonUtils.showToast(getContext(), "用户名不能为空");
                } else if (TextUtils.isEmpty(password)) {
                    CommonUtils.showToast(getContext(), "密码不能为空");
                } else {
                    ((LoginActivity) getActivity()).onRegisterClicked(username, password);
                }
            }
        });
    }
}
