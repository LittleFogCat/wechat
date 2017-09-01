package com.lfc.wechat.main.me;

import android.content.Context;

import com.lfc.wechat.base.BasePresenter;
import com.lfc.wechat.data.user.UserRepository;
import com.lfc.wechat.entity.User;
import com.lfc.wechat.entity.UserInfo;
import com.lfc.wechat.utils.RxUtils;
import com.lfc.wechat.utils.SpUtils;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by LittleFogCat on 2017/8/30.
 */

public class MePresenter extends BasePresenter<MeContract.View>
        implements MeContract.Presenter {
    private UserRepository mUserRepository;

    public MePresenter(Context context,
                       MeContract.View view
            , UserRepository userRepository) {
        super(context, view);
        mUserRepository = userRepository;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void loadUserInfo() {
        String username = SpUtils.readString(mContext, SpUtils.USERNAME);
        if (username == null || username.isEmpty()) {
            return;
        }
        Subscription subscription = mUserRepository.getUserInfo(username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxUtils.DefaultObserver<UserInfo>() {
                    @Override
                    public void onNext(UserInfo userInfo) {
                        if (userInfo == null) return;
                        mView.setAvatar(userInfo.getAvatarUrl());
                        mView.setNickname(userInfo.getNickname());
                        mView.setWxNum(userInfo.getWxNum());
                        mView.setQrCode(userInfo.getQrCode());
                    }
                });
        mSubscriptions.add(subscription);
    }
}
