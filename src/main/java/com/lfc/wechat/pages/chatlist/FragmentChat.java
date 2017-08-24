package com.lfc.wechat.pages.chatlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lfc.wechat.MessageItem;
import com.lfc.wechat.R;
import com.lfc.wechat.entity.Chat;
import com.lfc.wechat.model.message.MessageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jjy on 2017/4/2.
 */

public class FragmentChat extends Fragment {
    private static final String TAG = "FragmentChat";
    private RecyclerView mRecyclerView;

    public static FragmentChat newInstance() {

        Bundle args = new Bundle();

        FragmentChat fragment = new FragmentChat();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_fragment, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_message);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    void initView() {
        MessageRepository messageRepository = new MessageRepository();
        List<Chat> chatList = messageRepository.getChatList();
        List<MessageItem> messageItems = new ArrayList<>();
        for (int i = 0; i < 65; i++) {
            messageItems.add(new MessageItem(R.drawable.avatar_sample0, "第" + i + "条", System.currentTimeMillis() - new Random().nextInt(86400000)));
        }
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        final ChatListAdapter chatListAdapter = new ChatListAdapter(messageItems);
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
}
