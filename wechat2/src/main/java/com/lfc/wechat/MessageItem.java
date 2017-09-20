package com.lfc.wechat;

import android.view.View;

import java.util.Comparator;

/**
 * Created by jjy on 2017/4/2.
 */

public class MessageItem  {
    public MessageItem(int mAvatarId, String mTitle, String mLatestMsg, long mTime, int mVisibility) {
        this.mAvatarId = mAvatarId;
        this.mTitle = mTitle;
        this.mLatestMsg = mLatestMsg;
        this.mTime = mTime;
        this.mVisibility = mVisibility;
    }

    public MessageItem(int mAvatarId, String mTitle, long mTime) {
        this.mAvatarId = mAvatarId;
        this.mTitle = mTitle;
        this.mTime = mTime;
        this.mAvatarId = R.drawable.avatar_sample0;
        this.mVisibility = View.INVISIBLE;
    }

    public int mAvatarId;
    public String mTitle;
    public String mLatestMsg;
    public long mTime;
    public int mVisibility;

}
