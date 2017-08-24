package com.lfc.wechat.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 47510 on 2017/8/23.
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentView(), container, false);
        return view;
    }

    public abstract int getContentView();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initView();
    }

    public abstract void initView();
}
