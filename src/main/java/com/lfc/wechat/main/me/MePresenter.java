package com.lfc.wechat.main.me;

import com.lfc.wechat.base.BasePresenter;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public class MePresenter extends BasePresenter<MeContract.View>
        implements MeContract.Presenter {
    protected MePresenter(MeContract.View view) {
        super(view);
    }

    @Override
    public void subscribe() {

    }
}
