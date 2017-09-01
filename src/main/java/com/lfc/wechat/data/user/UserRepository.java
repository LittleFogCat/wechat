package com.lfc.wechat.data.user;

import com.lfc.wechat.data.BaseRepository;
import com.lfc.wechat.data.DataSource;
import com.lfc.wechat.entity.User;
import com.lfc.wechat.entity.UserInfo;
import com.lfc.wechat.global.GlobalConstant;

import rx.Observable;

/**
 * Created by LittleFogCat on 2017/8/31.
 */

public class UserRepository extends BaseRepository implements UserDataSource {
    private static UserRepository INSTANCE;
    private UserDataSource mRemoteDataSource;
    private UserDataSource mLocalDataSource;

    @Override
    public Observable<UserInfo> getUserInfo(String username) {
        return mRemoteDataSource.getUserInfo(username);
    }

    private UserRepository(UserDataSource remote, UserDataSource local) {
        mRemoteDataSource = remote;
        mLocalDataSource = local;
        if (GlobalConstant.USE_FAKE_DATA) {
            mRemoteDataSource = mLocalDataSource = new FakeUserDataSource();
        }
    }

    public static UserRepository getInstance(UserDataSource remote,
                                             UserDataSource local) {
        if (INSTANCE == null) {
            INSTANCE = new UserRepository(remote, local);
        }
        return INSTANCE;
    }
}
