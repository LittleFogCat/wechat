package com.lfc.wechat.main.discover;

import android.os.Bundle;

import com.lfc.wechat.R;
import com.lfc.wechat.base.BaseFragment;

/**
 * Created by 47510 on 2017/8/23.
 */

public class DiscoverFragment extends BaseFragment<DiscoverContract.Presenter>
        implements DiscoverContract.View {
    public static DiscoverFragment newInstance() {

        Bundle args = new Bundle();

        DiscoverFragment fragment = new DiscoverFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentView() {
        return R.layout.discover_fragment;
    }

    @Override
    public void initView() {

    }

    @Override
    public DiscoverContract.Presenter getPresenter() {
        return new DiscoverPresenter(this);
    }
}
