package com.lfc.wechat.main.settings;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.View;

import com.lfc.wechat.R;
import com.lfc.wechat.base.BaseDialog;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LittleFogCat on 2017/9/1.
 */

public class ExitDialog extends BaseDialog {
    @BindView(R.id.logout)
    View mLogout;
    @BindView(R.id.exit)
    View mExit;

    private OnOptionClickListener mOnOptionClickListener;

    public ExitDialog(@NonNull Context context, OnOptionClickListener listener) {
        super(context);
        mOnOptionClickListener = listener;
    }

    @Override
    protected int getContentView() {
        return R.layout.exit_dialog;
    }

    @Override
    protected void initView() {
        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnOptionClickListener.onLogoutClick();
            }
        });
        mExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnOptionClickListener.onExitClick();
            }
        });
    }

    void setOnOptionClickListener(OnOptionClickListener onOptionClickListener) {
        mOnOptionClickListener = onOptionClickListener;
    }

    public interface OnOptionClickListener {
        void onLogoutClick();

        void onExitClick();
    }
}
