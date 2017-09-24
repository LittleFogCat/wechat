package com.lfc.wechat.main.discover;

import com.lfc.wechat.base.IBasePresenter;
import com.lfc.wechat.base.IBaseView;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public interface DiscoverContract {
    interface View extends IBaseView<Presenter> {
    }

    interface Presenter extends IBasePresenter {
    }
}
