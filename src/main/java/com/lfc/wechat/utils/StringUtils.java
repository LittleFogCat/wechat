package com.lfc.wechat.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by LittleFogCat on 2017/8/23.
 * 字符串工具类
 */

public class StringUtils {
    public static String convertTimeFromLongToString(long time, String pattern) {
        DateFormat df = new SimpleDateFormat(pattern, Locale.getDefault());
        return df.format(new Date(time));
    }

    public static String convertTimeFromLongToChatListShowingPattern(long time) {
        DateFormat df;

        long current = System.currentTimeMillis();
        Calendar calendarC = Calendar.getInstance();
        calendarC.setTime(new Date(current));
        Calendar calendarT = Calendar.getInstance();
        calendarT.setTime(new Date(time));

        int currentYear = calendarC.get(Calendar.YEAR);
        int currentDayOfYear = calendarC.get(Calendar.DAY_OF_YEAR);
        int chatYear = calendarT.get(Calendar.YEAR);
        int chatDayOfYear = calendarT.get(Calendar.DAY_OF_YEAR);

        if (chatYear != currentYear) {
            df = new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA);
        } else if (currentDayOfYear - chatDayOfYear > 7) {
            df = new SimpleDateFormat("MM月dd日", Locale.CHINA);
        } else if (currentDayOfYear - chatDayOfYear > 1) {
            df = new SimpleDateFormat("EEEE", Locale.CHINA);
        } else if (currentDayOfYear - chatDayOfYear == 1) {
            df = new SimpleDateFormat("昨天", Locale.CHINA);
        } else {
            df = new SimpleDateFormat("HH:mm", Locale.CHINA);
        }

        return df.format(new Date(time));
    }
}
