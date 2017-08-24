package com.lfc.wechat.model;

import com.lfc.wechat.entity.Chat;
import com.lfc.wechat.entity.Message;
import com.lfc.wechat.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by 47510 on 2017/8/23.
 */

public class FakeDataCreator {
    private static String[] usernames = {"小明", "小红", "笑话", "小花"};

    public static String randomString(int minLen, int maxLen) {
        String str = "";
        Random random = new Random();
        for (int i = 0; ; i++) {
            if (i >= maxLen || i >= minLen && random.nextInt(maxLen - minLen) == 1) {
                break;
            }
            str += (char) (32 + random.nextInt(95));
        }
        return str;
    }

    public static Chat createFakeChat() {
        User user = createFakeUser();
        List<Message> messages = new ArrayList<>();
        Random random = new Random();
        while (true) {
            if (random.nextInt(10) == 1) {
                break;
            }
            messages.add(new Message(user, user, randomString(3, 18), System.currentTimeMillis(), System.currentTimeMillis()));
        }
        return new Chat(user, messages);
    }

    public static Message createFakeMessage() {
        return new Message(createFakeUser(), createFakeUser(), randomString(3, 18), System.currentTimeMillis(), System.currentTimeMillis());
    }

    public static User createFakeUser() {
        return new User("1", usernames[new Random().nextInt(4)], "https://www.baidu.com/img/baidu_jgylogo3.gif", "四川南昌");
    }
}
