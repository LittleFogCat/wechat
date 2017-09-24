package com.lfc.wechat.main.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.lfc.wechat.R;
import com.lfc.wechat.base.BaseBackToolbarFragment;
import com.lfc.wechat.login.LoginActivity;

import butterknife.BindView;

/**
 * Created by LittleFogCat on 2017/9/1.
 */

public class SettingsFragment extends BaseBackToolbarFragment<SettingsContract.Presenter>
        implements SettingsContract.View {
    @BindView(R.id.exit)
    View mExit;

    ExitDialog mExitDialog;

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

    @NonNull
    @Override
    public String getTitle() {
        return getString(R.string.setting);
    }

    @Override
    public void initMainView() {
        mExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExitDialog = new ExitDialog(getContext(), new ExitDialog.OnOptionClickListener() {
                    @Override
                    public void onLogoutClick() {
                        mPresenter.logout();
                    }

                    @Override
                    public void onExitClick() {
                        getBaseActivity().exit();
                    }
                });
                mExitDialog.show();
            }
        });
    }

    @Override
    public void onLogoutSuccess() {
        if (mExitDialog != null && mExitDialog.isShowing()) {
            mExitDialog.dismiss();
        }
        getBaseActivity().finishAll();
        startActivity(new Intent(getContext(), LoginActivity.class));
    }
}
