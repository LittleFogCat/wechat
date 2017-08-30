package com.lfc.wechat.main.chatlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lfc.wechat.R;
import com.lfc.wechat.base.BaseRecyclerAdapter;
import com.lfc.wechat.entity.Chat;
import com.lfc.wechat.entity.Message;
import com.lfc.wechat.utils.StringUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jjy on 2017/4/2.
 */

public class ChatListAdapter extends BaseRecyclerAdapter<Chat, ChatListAdapter.ViewHolder> {
    private static final String TAG = "ChatListAdapter";

    public ChatListAdapter(Context context, List<Chat> list, OnItemClickListener listener) {
        super(context, list, listener);
        Collections.sort(getItems(), new Comparator<Chat>() {
            @Override
            public int compare(Chat chat1, Chat chat2) {
                Message lastMsg1 = getLatestMsg(chat1);
                Log.d(TAG, "compare: " + lastMsg1);
                Message lastMsg2 = getLatestMsg(chat2);
                Log.d(TAG, "compare: " + lastMsg2);
                return (int) (lastMsg2.getReceiveTime() - lastMsg1.getReceiveTime());
            }
        });
    }

    public class ViewHolder extends BaseRecyclerAdapter.BaseViewHolder {
        ImageView mAvatar;
        TextView mTitle;
        TextView mLatestMsg;
        TextView mTime;
        ImageView mBlockMsg;

        public ViewHolder(View view) {
            super(view);
            mAvatar = (ImageView) view.findViewById(R.id.img_msg_avatar);
            mTitle = (TextView) view.findViewById(R.id.txt_msg_title);
            mLatestMsg = (TextView) view.findViewById(R.id.txt_msg_latest);
            mTime = (TextView) view.findViewById(R.id.txt_msg_time);
            mBlockMsg = (ImageView) view.findViewById(R.id.img_msg_block);
        }
    }

    private Message getLatestMsg(Chat chat) {
        Message last = null;
        for (Message message : chat.getMessageList()) {
            if (last == null || message.getReceiveTime() > last.getReceiveTime()) {
                last = message;
            }
        }
        return last;
    }

    @Override
    public void onBindBaseViewHolder(ViewHolder holder, int position) {
        Chat item = getItems().get(position);
        Message lastMsg = getLatestMsg(item);
        Glide.with(mContext).load(item.getFromUser().getAvatarUrl()).apply(new RequestOptions().centerCrop()).into(holder.mAvatar);
        holder.mTitle.setText(item.getFromUser().getNickname());
        holder.mLatestMsg.setText(lastMsg.getContent());
        holder.mTime.setText(StringUtils.convertTimeFromLongToChatListShowingPattern(lastMsg.getReceiveTime()));
        holder.mBlockMsg.setVisibility(item.mVisibility);
    }

    @Override
    protected int getItemContentView() {
        return R.layout.message_item;
    }

    @Override
    protected ViewHolder getViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }
}
