package com.lfc.wechat.utils;

import java.util.Random;

/**
 * Created by LittleFogCat on 2017/8/25.
 * 随机工具类
 */

public class RandomUtils {
    /**
     * 生成一个在from到to之间的整数
     *
     * @param from 最小值 include
     * @param to   最大值 exclude
     * @return 随机整数
     */
    public static long randomInt(int from, int to) {
        if (to <= from)
            throw new IllegalArgumentException("to must be bigger than from!");
        return (from + new Random().nextInt(to - from));
    }

    /**
     * 随机生成时间戳，从day天前到当前时间之间的任意一个时间点
     */
    public static long randomTimeDownFromCurrent(int day) {
        return System.currentTimeMillis() - new Random().nextInt(day * 86400000);
    }

    /**
     * 生成随机字符串
     *
     * @param minLen 最小长度
     * @param maxLen 最大长度
     * @return 生成的随机字符串
     */
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
}
