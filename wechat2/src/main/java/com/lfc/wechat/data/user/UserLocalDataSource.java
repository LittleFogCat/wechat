package com.lfc.wechat.data.user;

import com.lfc.wechat.entity.UserInfo;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by LittleFogCat on 2017/8/31.
 */

public class UserLocalDataSource implements UserDataSource {
    @Override
    public Observable<UserInfo> getUserInfo(String username) {
        return null;
    }
}
