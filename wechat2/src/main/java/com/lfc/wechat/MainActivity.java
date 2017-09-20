package com.lfc.wechat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lfc.wechat.base.BaseActivity;
import com.lfc.wechat.main.chatlist.ChatListFragment;
import com.lfc.wechat.main.chatlist.MyPagerAdapter;
import com.lfc.wechat.main.contacts.ContactFragment;
import com.lfc.wechat.main.discover.DiscoverFragment;
import com.lfc.wechat.main.me.MeFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    @BindView(R.id.header)
    Toolbar toolbar;
    @BindView(R.id.footer_chats)
    RelativeLayout footerChats;
    @BindView(R.id.footer_contacts)
    RelativeLayout footerContacts;
    @BindView(R.id.footer_discover)
    RelativeLayout footerDiscover;
    @BindView(R.id.footer_me)
    RelativeLayout footerMe;
    @BindView(R.id.footer)
    LinearLayout footerLayout;

    List<RelativeLayout> footItems;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    Fragment mChatListFragment, mContactFragment, mDiscoverFragment, mMeFragment;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        initWidgets();
        initBody();
        initFooter();
    }

    //初始化头部
    void initWidgets() {
        toolbar = (Toolbar) findViewById(R.id.header);

        setSupportActionBar(toolbar);
        toolbar.hideOverflowMenu();
    }

    //初始化中部
    void initBody() {
        mChatListFragment = ChatListFragment.newInstance();
        mContactFragment = ContactFragment.newInstance();
        mDiscoverFragment = DiscoverFragment.newInstance();
        mMeFragment = MeFragment.newInstance();
        List<Fragment> fragments = new ArrayList<>(Arrays.asList(mChatListFragment, mContactFragment, mDiscoverFragment, mMeFragment));

        FragmentPagerAdapter pagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), fragments) {
            @Override
            public int getItemPosition(Object object) {
                return POSITION_NONE;
            }
        };

        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                float colorOffset = positionOffset * positionOffset * positionOffset;
                footItems.get(position).findViewById(R.id.img_footer).setAlpha(colorOffset);
                footItems.get(position).findViewById(R.id.img_footer_fill).setAlpha(1 - colorOffset);
                footItems.get(position).findViewById(R.id.txt_footer).setAlpha(colorOffset);
                footItems.get(position).findViewById(R.id.txt_footer_fill).setAlpha(1 - colorOffset);
                if (position < footItems.size() - 1) {
                    footItems.get(position + 1).findViewById(R.id.img_footer).setAlpha(1 - colorOffset);
                    footItems.get(position + 1).findViewById(R.id.img_footer_fill).setAlpha(colorOffset);
                    footItems.get(position + 1).findViewById(R.id.txt_footer).setAlpha(1 - colorOffset);
                    footItems.get(position + 1).findViewById(R.id.txt_footer_fill).setAlpha(colorOffset);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //初始化底部
    void initFooter() {
        footItems = new ArrayList<>(Arrays.asList(footerChats, footerContacts, footerDiscover, footerMe));

        footerChats.setOnClickListener(this);
        footerContacts.setOnClickListener(this);
        footerDiscover.setOnClickListener(this);
        footerMe.setOnClickListener(this);

        ((ImageView) footerChats.findViewById(R.id.img_footer)).setImageResource(R.drawable.bottom_chat);
        ((ImageView) footerChats.findViewById(R.id.img_footer_fill)).setImageResource(R.drawable.bottom_chat_fill);
        ((TextView) footerChats.findViewById(R.id.txt_footer)).setText("Chats");
        ((TextView) footerChats.findViewById(R.id.txt_footer_fill)).setText("Chats");
        ((ImageView) footerContacts.findViewById(R.id.img_footer)).setImageResource(R.drawable.bottom_contacts);
        ((ImageView) footerContacts.findViewById(R.id.img_footer_fill)).setImageResource(R.drawable.bottom_contacts_fill);
        ((TextView) footerContacts.findViewById(R.id.txt_footer)).setText("Contacts");
        ((TextView) footerContacts.findViewById(R.id.txt_footer_fill)).setText("Contacts");
        ((ImageView) footerDiscover.findViewById(R.id.img_footer)).setImageResource(R.drawable.bottom_discover);
        ((ImageView) footerDiscover.findViewById(R.id.img_footer_fill)).setImageResource(R.drawable.bottom_discover_fill);
        ((TextView) footerDiscover.findViewById(R.id.txt_footer)).setText("Discover");
        ((TextView) footerDiscover.findViewById(R.id.txt_footer_fill)).setText("Discover");
        ((ImageView) footerMe.findViewById(R.id.img_footer)).setImageResource(R.drawable.bottom_me);
        ((ImageView) footerMe.findViewById(R.id.img_footer_fill)).setImageResource(R.drawable.bottom_me_fill);
        ((TextView) footerMe.findViewById(R.id.txt_footer)).setText("Me");
        ((TextView) footerMe.findViewById(R.id.txt_footer_fill)).setText("Me");
    }

    @Override
    public void onClick(View v) {
        int moveToPage = 0;
        switch (v.getId()) {
            case R.id.footer_chats:
            case R.id.footer_contacts:
            case R.id.footer_discover:
            case R.id.footer_me:
                setChosen(v);
            default:
                break;
        }
    }

    void setChosen(View footItem) {
        for (int i = 0; i < footItems.size(); i++)/*RelativeLayout r : footItems)*/ {
            Log.e(TAG, "setChosen: " + i);
            footItems.get(i).findViewById(R.id.img_footer).setAlpha(1);
            footItems.get(i).findViewById(R.id.img_footer_fill).setAlpha(0);
            footItems.get(i).findViewById(R.id.txt_footer).setAlpha(1);
            footItems.get(i).findViewById(R.id.txt_footer_fill).setAlpha(0);
        }
        footItem.findViewById(R.id.img_footer).setAlpha(0);
        footItem.findViewById(R.id.img_footer_fill).setAlpha(1);
        footItem.findViewById(R.id.txt_footer).setAlpha(0);
        footItem.findViewById(R.id.txt_footer_fill).setAlpha(1);
        switch (footItem.getId()) {
            case R.id.footer_chats:
                viewPager.setCurrentItem(0, false);
                break;
            case R.id.footer_contacts:
                viewPager.setCurrentItem(1, false);
                break;
            case R.id.footer_discover:
                viewPager.setCurrentItem(2, false);
                break;
            case R.id.footer_me:
                viewPager.setCurrentItem(3, false);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
//                PopupMenu popupMenu = new PopupMenu(this, item.getActionView());
//                popupMenu.show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
//            if (menu.getClass().getSimpleName().equals("MenuBuilder")){
//                try {
        if (menu != null && menu instanceof MenuBuilder) {
            ((MenuBuilder) menu).setOptionalIconsVisible(true);
        }
//                    Method m=menu.getClass().getDeclaredMethod("setOptionalIconsVisible",Boolean.TYPE);
//                    m.invoke(menu,true);
//                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
        return super.onPrepareOptionsMenu(menu);
    }

    public void refreshViewPager() {
        viewPager.getAdapter().notifyDataSetChanged();
        Log.d(TAG, "refreshViewPager: " + getSupportFragmentManager().getFragments());
    }
}
