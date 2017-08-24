package com.lfc.wechat.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by 47510 on 2017/8/23.
 */

public class StringUtils {
    public static String convertFromLongToString(long time, String pattern) {
        DateFormat df = new SimpleDateFormat(pattern, Locale.getDefault());
        return df.format(new Date(time));
    }
}
