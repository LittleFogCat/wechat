package com.lfc.wechat.main.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lfc.wechat.R;
import com.lfc.wechat.base.BaseFragment;
import com.lfc.wechat.login.LoginActivity;

import butterknife.BindView;

/**
 * Created by LittleFogCat on 2017/9/1.
 */

public class SettingsFragment extends BaseFragment<SettingsContract.Presenter>
        implements SettingsContract.View {
    @BindView(R.id.exit)
    View mExit;

    public static SettingsFragment newInstance() {
        Bundle args = new Bundle();
        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public SettingsContract.Presenter getPresenter() {
        return new SettingsPresenter(getContext(), this);
    }

    @Override
    public int getContentView() {
        return R.layout.settings_fragment;
    }

    @Override
    public void initView() {
        mExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExitDialog exitDialog = new ExitDialog(getContext(), new ExitDialog.OnOptionClickListener() {
                    @Override
                    public void onLogoutClick() {
                        mPresenter.logout();
                    }

                    @Override
                    public void onExitClick() {
                        getBaseActivity().exit();
                    }
                });
                exitDialog.show();
            }
        });
    }

    @Override
    public void onLogoutSuccess() {
        getBaseActivity().finishAll();
        startActivity(new Intent(getContext(), LoginActivity.class));
    }
}
