package com.lfc.wechat.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lfc.wechat.R;
import com.lfc.wechat.base.BaseFragment;
import com.lfc.wechat.base.IBasePresenter;

import butterknife.BindView;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public class LoginFragment extends BaseFragment {

    @BindView(R.id.et_username)
    EditText mEtUsername;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.btn_login)
    TextView mLogin;
    @BindView(R.id.back)
    ImageView mBack;

    public static LoginFragment newInstance() {
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public IBasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getContentView() {
        return R.layout.login_fragment;
    }

    @Override
    public void initView() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mEtUsername.getText().toString();
                String password = mEtPassword.getText().toString();
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(getContext(), "用户名不能为空", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getContext(), "密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    ((LoginActivity) getActivity()).onLoginClicked(username, password);
                }
            }
        });
    }

}
