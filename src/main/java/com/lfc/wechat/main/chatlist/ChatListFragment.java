package com.lfc.wechat.main.chatlist;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lfc.wechat.R;
import com.lfc.wechat.base.BaseFragment;
import com.lfc.wechat.entity.Chat;
import com.lfc.wechat.data.message.MessageRepository;

import java.util.List;

import butterknife.BindView;

/**
 * Created by jjy on 2017/4/2.
 */

public class ChatListFragment extends BaseFragment<ChatListContract.Presenter>
        implements ChatListContract.View {
    private static final String TAG = "ChatListFragment";
    @BindView(R.id.recycler_view_message)
    RecyclerView mRecyclerView;

    public static ChatListFragment newInstance() {
        Bundle args = new Bundle();
        ChatListFragment fragment = new ChatListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentView() {
        return R.layout.chat_fragment;
    }

    public void initView() {
        MessageRepository messageRepository = new MessageRepository();
        List<Chat> chatList = messageRepository.getChatList();
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        final ChatListAdapter chatListAdapter = new ChatListAdapter(getContext(), chatList, null);
        mRecyclerView.setAdapter(chatListAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Log.i(TAG, "onScrolled: dx = " + dx + "  dy = " + dy);
                RecyclerView.LayoutManager lm = mRecyclerView.getLayoutManager();
                View v = lm.getChildAt(0);
                if (v != null) {
                    TextView tv = (TextView) v.findViewById(R.id.txt_msg_title);
                    Log.i(TAG, "onScrolled: " + tv.getText());
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @Override
    public ChatListContract.Presenter getPresenter() {
        return new ChatListPresenter(getContext(),this);
    }
}
