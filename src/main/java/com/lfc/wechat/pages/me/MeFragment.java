package com.lfc.wechat.pages.me;

import android.os.Bundle;

import com.lfc.wechat.R;
import com.lfc.wechat.base.BaseFragment;

/**
 * Created by 47510 on 2017/8/23.
 */

public class MeFragment extends BaseFragment {
    public static MeFragment newInstance() {

        Bundle args = new Bundle();

        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentView() {
        return R.layout.me_fragment;
    }

    @Override
    public void initView() {

    }
}
