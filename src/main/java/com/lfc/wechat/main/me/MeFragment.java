package com.lfc.wechat.main.me;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lfc.wechat.MainActivity;
import com.lfc.wechat.R;
import com.lfc.wechat.base.BaseFragment;
import com.lfc.wechat.base.BaseMVPActivity;
import com.lfc.wechat.data.user.UserLocalDataSource;
import com.lfc.wechat.data.user.UserRemoteDataSource;
import com.lfc.wechat.data.user.UserRepository;
import com.lfc.wechat.entity.UserInfo;
import com.lfc.wechat.main.settings.SettingsFragment;
import com.lfc.wechat.utils.CommonUtils;

import butterknife.BindView;

/**
 * Created by 47510 on 2017/8/23.
 */

public class MeFragment extends BaseFragment<MeContract.Presenter>
        implements MeContract.View {
    @BindView(R.id.avatar)
    ImageView mAvatar;
    @BindView(R.id.nickname)
    TextView mNickname;
    @BindView(R.id.wx_num)
    TextView mWxNum;
    @BindView(R.id.qr_code)
    ImageView mQrCode;

    @BindView(R.id.wallet)
    View mWallet;
    @BindView(R.id.collection)
    View mCollection;
    @BindView(R.id.photo)
    View mPhoto;
    @BindView(R.id.cards)
    View mCards;
    @BindView(R.id.emoticon)
    View mEmoticon;
    @BindView(R.id.settings)
    View mSettings;

    public static MeFragment newInstance() {
        Bundle args = new Bundle();
        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentView() {
        return R.layout.me_fragment;
    }

    @Override
    public void initView() {
        Log.d(TAG, "initView: mWallet " + mWallet.getId());
        initUserInfo();
        setOptionsClickListener();
    }

    @Override
    public void setAvatar(String url) {

    }

    @Override
    public void setNickname(String nickname) {

    }

    @Override
    public void setWxNum(String wxNum) {

    }

    @Override
    public void setQrCode(String url) {

    }

    private void initUserInfo() {
        mPresenter.loadUserInfo();
    }

    private void setOptionsClickListener() {
        mWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonUtils.showToast(getContext(), "wallet");
            }
        });
        mCollection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mEmoticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonUtils.addFragment(getFragmentManager(), SettingsFragment.newInstance(), R.id.content_frame);
                ((MainActivity) getBaseActivity()).refreshViewPager();
            }
        });
    }

    @Override
    public MeContract.Presenter getPresenter() {
        return new MePresenter(getContext(),
                this,
                UserRepository.getInstance(new UserRemoteDataSource(), new UserLocalDataSource()));
    }
}
