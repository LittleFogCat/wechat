package com.lfc.wechat.model;

import android.util.Log;
import android.view.View;

import com.lfc.wechat.entity.Chat;
import com.lfc.wechat.entity.Message;
import com.lfc.wechat.entity.User;
import com.lfc.wechat.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.lfc.wechat.utils.RandomUtils.randomString;

/**
 * Created by 47510 on 2017/8/23.
 */

public class FakeDataCreator {
    private static final String TAG = "FakeDataCreator";
    private static String[] usernames = {
            "小明", "小红", "笑话", "小花",
            "大米", "大花", "大明", "冷笑话",
            "风中颤抖", "瑟瑟发抖", "举重若轻", "风轻云淡",
            "吔屎啦", "一个温柔的弱女子", "一个强悍的女汉子"
    };
    private static String[] imgUrls = {
            "http://mpic.tiankong.com/b18/b62/b18b62b9b3573fdbeb438dcc5ba9d8ed/eu16-bja0548.jpg@300h",
            "http://mpic.tiankong.com/f92/c9d/f92c9dd7e62df59db9cd26dcd289cd03/1K-14720.jpg@300h",
            "http://mpic.tiankong.com/bd4/ea6/bd4ea67e28dcc86aec6009ad0c2ef0bd/640.jpg@300h",
            "http://mpic.tiankong.com/11e/cec/11ecec93e8da6efef9dab2f3f539513a/640.jpg@300h",
            "http://mpic.tiankong.com/8b7/b4c/8b7b4c3caa6d164ef71d8956dbaabfd3/640.jpg@300h",
            "http://mpic.tiankong.com/fe4/b77/fe4b7713db8ff0049980e5118cd55eb5/640.jpg@300h",
            "http://mpic.tiankong.com/fb3/736/fb373609a44e85d43cb3ec15ec554e8d/640.jpg@300h",
            "http://pic.cdhdky.com/download/20170523_145546740.jpg",
            "http://www.cdhdky.com/images/ttt.jpg",
            "http://www.cdhdky.com/images/5rrrrrrr123.jpg",
            "http://pic.cdhdky.com/download/20170523_145518529.jpg"
    };


    public static Chat createFakeChat() {
        User user = createFakeUser();
        List<Message> messages = new ArrayList<>();
        Random random = new Random();
        while (true) {
            if (random.nextInt(5) == 1 && !messages.isEmpty()) {
                break;
            }
            Message fakeMsg = new Message()
                    .fromUser(user)
                    .toUser(user)
                    .content(randomString(3, 18))
                    .sendTime(System.currentTimeMillis())
                    .receiveTime(RandomUtils.randomTimeDownFromCurrent(365));
//            Log.d(TAG, "createFakeChat: " + fakeMsg);
            messages.add(fakeMsg);
        }
//        Log.d(TAG, "createFakeChat: =====================");
//        Log.d(TAG, "createFakeChat: " + messages);
        return new Chat(user, messages).visibility(View.GONE);
    }

    public static Message createFakeMessage() {
        return new Message()
                .fromUser(createFakeUser())
                .toUser(createFakeUser())
                .content(randomString(3, 18))
                .sendTime(System.currentTimeMillis())
                .receiveTime(RandomUtils.randomTimeDownFromCurrent(365));
    }

    public static User createFakeUser() {
        return new User()
                .username("1")
                .nickname(usernames[new Random().nextInt(usernames.length)])
                .avatarUrl(imgUrls[new Random().nextInt(imgUrls.length)])
                .area("四川南昌起义勇兵进行曲");
    }
}
