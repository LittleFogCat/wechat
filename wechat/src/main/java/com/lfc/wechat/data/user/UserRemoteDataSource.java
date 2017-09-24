package com.lfc.wechat.data.user;

import com.lfc.wechat.entity.UserInfo;
import com.lfc.wechat.throwable.UserNotFoundException;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by LittleFogCat on 2017/8/31.
 */

public class UserRemoteDataSource implements UserDataSource {
    @Override
    public Observable<UserInfo> getUserInfo(String username) {
        BmobQuery<UserInfo> query = new BmobQuery<>();
        query.addWhereEqualTo("username", username);
        return query.findObjectsObservable(UserInfo.class)
                .map(new Func1<List<UserInfo>, UserInfo>() {
                    @Override
                    public UserInfo call(List<UserInfo> userInfos) {
                        if (userInfos == null || userInfos.isEmpty())
                            return null;
                        return userInfos.get(0);
                    }
                });
    }
}
