package com.lfc.wechat.data.user;

import com.lfc.wechat.entity.UserInfo;

import rx.Observable;

/**
 * Created by LittleFogCat on 2017/8/31.
 */

public class FakeUserDataSource implements UserDataSource {
    @Override
    public Observable<UserInfo> getUserInfo(String username) {
        return Observable.just(new UserInfo());
    }
}
