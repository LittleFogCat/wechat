package com.lfc.wechat.main.contacts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.lfc.wechat.R;
import com.lfc.wechat.base.BaseFragment;

/**
 * Created by 47510 on 2017/8/23.
 */

public class ContactFragment extends BaseFragment<ContactContract.Presenter>
        implements ContactContract.View {

    public static ContactFragment newInstance() {

        Bundle args = new Bundle();

        ContactFragment fragment = new ContactFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentView() {
        return R.layout.contact_fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void initView() {
        // TODO: 2017/8/23
    }

    @Override
    public ContactContract.Presenter getPresenter() {
        return new ContactPresenter(this);
    }
}
