package com.lfc.wechat;

import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jjy on 2017/4/2.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<MessageItem> mMessages;

    MyAdapter(List<MessageItem> list) {
        mMessages = list;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mAvatar;
        TextView mTitle;
        TextView mLatestMsg;
        TextView mTime;
        ImageView mBlockMsg;

        ViewHolder(View view) {
            super(view);
            mAvatar = (ImageView) view.findViewById(R.id.img_msg_avatar);
            mTitle = (TextView) view.findViewById(R.id.txt_msg_title);
            mLatestMsg= (TextView) view.findViewById(R.id.txt_msg_latest);
            mTime= (TextView) view.findViewById(R.id.txt_msg_time);
            mBlockMsg= (ImageView) view.findViewById(R.id.img_msg_block);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MessageItem item = mMessages.get(position);
        holder.mAvatar.setImageResource(item.mAvatarId);
        holder.mTitle.setText(item.mTitle);
        holder.mLatestMsg.setText(item.mLatestMsg);
        holder.mTime.setText(item.mTime);
        holder.mBlockMsg.setVisibility(item.mVisibility);
    }

    @Override
    public int getItemCount() {
        if (mMessages != null)
            return mMessages.size();
        return 0;
    }
}
