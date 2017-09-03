package com.lfc.wechat.base;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lfc.wechat.R;

import butterknife.BindView;

/**
 * Created by LittleFogCat on 2017/9/3.
 */

public abstract class BaseBackToolbarFragment<P extends IBasePresenter> extends BaseFragment<P> {
    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.title)
    TextView mTitle;

    @Override
    public final void initView() {
        mTitle.setText(getTitle());
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });
        initMainView();
    }

    /**
     * 设置标题
     *
     * @return 标题
     */
    @NonNull
    public abstract String getTitle();

    public abstract void initMainView();
}
