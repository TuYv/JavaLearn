package com.max.learning.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author max
 * @date 2021/7/5 18:04
 */
public class DateUtils {

    public static String stringNowTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
}
