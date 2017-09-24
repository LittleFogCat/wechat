package com.lfc.wechat.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ui.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by LittleFogCat on 2017/8/24.
 * RecyclerView Adapter的基础类
 */

public abstract class BaseRecyclerAdapter<T, VH extends BaseRecyclerAdapter.BaseViewHolder> extends RecyclerView.Adapter<VH> {

    protected List<T> mItems = new ArrayList<>();
    protected Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public BaseRecyclerAdapter(Context context) {
        mContext = context;
    }

    public BaseRecyclerAdapter(Context context, List<T> items) {
        mContext = context;
        mItems = items;
    }

    public BaseRecyclerAdapter(Context context, List<T> items, OnItemClickListener onItemClickListener) {
        mContext = context;
        mItems = items;
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(mContext).inflate(getItemContentView(), parent, false);
        return getViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final VH holder, int position) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(holder, holder.getAdapterPosition());
                }
            });
        }
        onBindBaseViewHolder(holder, position);
    }

    public abstract void onBindBaseViewHolder(VH holder, int position);

    /**
     * 返回item布局的id
     */
    protected abstract int getItemContentView();

    /**
     * 返回一个ViewHolder的实例
     */
    protected abstract VH getViewHolder(View itemView);

    public static class BaseViewHolder extends RecyclerView.ViewHolder {

        public BaseViewHolder(View itemView) {
            super(itemView);
            AutoUtils.autoSize(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    /**
     * 设置列表数据
     */
    public void setDatas(List<T> datas) {
        mItems.clear();
        if (datas != null) {
            mItems.addAll(datas);
        }
        notifyDataSetChanged();
    }

    /**
     * 往列表中添加一项
     */
    public void addItem(T item) {
        mItems.add(item);
        notifyItemInserted(mItems.size());
    }

    /**
     * 获取数据列表
     */
    public List<T> getItems() {
        return mItems;
    }

    protected interface OnItemClickListener {
        void onItemClick(BaseViewHolder holder, int position);
    }
}
