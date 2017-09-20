package com.lfc.wechat.data.user;

import com.lfc.wechat.data.DataSource;
import com.lfc.wechat.entity.UserInfo;

import rx.Observable;

/**
 * Created by LittleFogCat on 2017/8/31.
 */

public interface UserDataSource extends DataSource {
    Observable<UserInfo> getUserInfo(String username);
}
