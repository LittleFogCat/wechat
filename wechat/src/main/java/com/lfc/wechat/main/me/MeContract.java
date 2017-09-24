package com.lfc.wechat.main.me;

import com.lfc.wechat.base.IBasePresenter;
import com.lfc.wechat.base.IBaseView;
import com.lfc.wechat.entity.UserInfo;

import rx.Observable;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public interface MeContract {
    interface View extends IBaseView<Presenter> {
        void setAvatar(String url);

        void setNickname(String nickname);

        void setWxNum(String wxNum);

        void setQrCode(String url);
    }

    interface Presenter extends IBasePresenter {
        void loadUserInfo();
    }
}
