package com.lfc.wechat.main.settings;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;

import com.lfc.wechat.base.BasePresenter;
import com.lfc.wechat.utils.SpUtils;

/**
 * Created by LittleFogCat on 2017/9/1.
 */

public class SettingsPresenter extends BasePresenter<SettingsContract.View>
        implements SettingsContract.Presenter {
    public SettingsPresenter(Context context, SettingsContract.View view) {
        super(context, view);
    }

    @Override
    public void logout() {
        SpUtils.saveString(mContext, SpUtils.USERNAME, null);
        SpUtils.saveString(mContext, SpUtils.PASSWORD, null);

    }

    @Override
    public void subscribe() {

    }
}
