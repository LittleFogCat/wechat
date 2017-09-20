package com.lfc.wechat.main.discover;

import android.content.Context;

import com.lfc.wechat.base.BasePresenter;
import com.lfc.wechat.base.IBaseView;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public class DiscoverPresenter extends BasePresenter<DiscoverContract.View>
        implements DiscoverContract.Presenter {
    protected DiscoverPresenter(Context context, DiscoverContract.View view) {
        super(context, view);
    }

    @Override
    public void subscribe() {

    }
}
