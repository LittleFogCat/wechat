package com.lfc.wechat;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jauker.widget.BadgeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    Toolbar toolbar;

    RelativeLayout footerChats, footerContacts, footerDiscover, footerMe;
    List<RelativeLayout> footItems;
    LinearLayout footerLayout;

    View page1, page2, page3, page4;
    RecyclerView recyclerViewMsg;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        initWidgets();
        initBody();
        initFooter();
        BadgeView badgeView = new BadgeView(this);
        badgeView.setTargetView(toolbar.findViewById(R.id.menu_add_contacts));
//        badgeView.setTargetView();
        badgeView.setBadgeCount(5);
    }

    //初始化头部
    void initWidgets() {
        toolbar = (Toolbar) findViewById(R.id.header);

        setSupportActionBar(toolbar);
        toolbar.hideOverflowMenu();
    }

    //初始化中部
    void initBody() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        LayoutInflater inflater = getLayoutInflater();
        page1 = inflater.inflate(R.layout.page1, null);
        page2 = inflater.inflate(R.layout.page2, null);
        page3 = inflater.inflate(R.layout.page3, null);
        page4 = inflater.inflate(R.layout.page4, null);
        final List<View> pages = new ArrayList<>();
        pages.add(page1);
        pages.add(page2);
        pages.add(page3);
        pages.add(page4);

//        listView = (ListView) page1.findViewById(R.id.list_view_message);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
//        adapter.addAll(msgs);
//        listView.setAdapter(adapter);

        recyclerViewMsg = (RecyclerView) page1.findViewById(R.id.recycler_view_message);
        List<MessageItem> messageItems = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            messageItems.add(new MessageItem(R.drawable.avatar_sample0, "第" + i + "条", new Random().nextInt(24) + ":" + new Random().nextInt(59)));
        }
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerViewMsg.setLayoutManager(mLayoutManager);
        MyAdapter myAdapter = new MyAdapter(messageItems);
        recyclerViewMsg.setAdapter(myAdapter);



        PagerAdapter pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return pages.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(pages.get(position));
                return pages.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(pages.get(position));
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
        footerLayout = (LinearLayout) findViewById(R.id.footer);
        footerChats = (RelativeLayout) findViewById(R.id.footer_chats);
        footerContacts = (RelativeLayout) findViewById(R.id.footer_contacts);
        footerDiscover = (RelativeLayout) findViewById(R.id.footer_discover);
        footerMe = (RelativeLayout) findViewById(R.id.footer_me);
        footItems = new ArrayList<>();
        footItems.add(footerChats);
        footItems.add(footerContacts);
        footItems.add(footerDiscover);
        footItems.add(footerMe);

        footerChats.setOnClickListener(this);
        footerContacts.setOnClickListener(this);
        footerDiscover.setOnClickListener(this);
        footerMe.setOnClickListener(this);

        ((ImageView) footerChats.findViewById(R.id.img_footer)).setImageResource(R.drawable.bottom_chat);
        ((ImageView) footerChats.findViewById(R.id.img_footer_fill)).setImageResource(R.drawable.bottom_chat_fill);
        ((TextView) footerChats.findViewById(R.id.txt_footer)).setText("Chats");
        ((TextView) footerChats.findViewById(R.id.txt_footer_fill)).setText("Chats");
//        ((TextView) footerChatsFill.findViewById(R.id.txt_footer)).setText("Chats");
        ((ImageView) footerContacts.findViewById(R.id.img_footer)).setImageResource(R.drawable.bottom_contacts);
        ((ImageView) footerContacts.findViewById(R.id.img_footer_fill)).setImageResource(R.drawable.bottom_contacts_fill);
        ((TextView) footerContacts.findViewById(R.id.txt_footer)).setText("Contacts");
        ((TextView) footerContacts.findViewById(R.id.txt_footer_fill)).setText("Contacts");
//        ((TextView) footerContactsFill.findViewById(R.id.txt_footer)).setText("Contacts");
        ((ImageView) footerDiscover.findViewById(R.id.img_footer)).setImageResource(R.drawable.bottom_discover);
        ((ImageView) footerDiscover.findViewById(R.id.img_footer_fill)).setImageResource(R.drawable.bottom_discover_fill);
        ((TextView) footerDiscover.findViewById(R.id.txt_footer)).setText("Discover");
        ((TextView) footerDiscover.findViewById(R.id.txt_footer_fill)).setText("Discover");
//        ((TextView) footerDiscoverFill.findViewById(R.id.txt_footer)).setText("Discover");
        ((ImageView) footerMe.findViewById(R.id.img_footer)).setImageResource(R.drawable.bottom_me);
        ((ImageView) footerMe.findViewById(R.id.img_footer_fill)).setImageResource(R.drawable.bottom_me_fill);
        ((TextView) footerMe.findViewById(R.id.txt_footer)).setText("Me");
        ((TextView) footerMe.findViewById(R.id.txt_footer_fill)).setText("Me");
//        ((TextView) footerMeFill.findViewById(R.id.txt_footer)).setText("Me");

        footerChats.setOnClickListener(this);
        footerContacts.setOnClickListener(this);
        footerDiscover.setOnClickListener(this);
        footerMe.setOnClickListener(this);
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
        if (menu != null) {
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

}
