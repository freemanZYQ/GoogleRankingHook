package net.luna.common.util;

import android.annotation.SuppressLint;
import android.text.format.DateUtils;

import net.luna.common.debug.LunaLog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TimeUtils
 */
@SuppressLint("SimpleDateFormat")
public class TimeUtils {

    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DATE_FORMAT_DATE = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 1秒的毫秒数:1000毫秒
     */
    public static final long oneSecond_ms = 1000;

    /**
     * 1分钟的毫秒数:60秒*1000毫秒
     */
    public static final long oneMinute_ms = 60 * oneSecond_ms;

    /**
     * 1小时的毫秒数:60分钟*60秒*1000毫秒
     */
    public static final long oneHour_ms = 60 * oneMinute_ms;

    /**
     * 1天的毫秒数:24小时*60分钟*60秒*1000毫秒
     */
    public static final long oneDay_ms = 24 * oneHour_ms;

    /**
     * 1周的毫秒数:7天*24小时*60分钟*60秒*1000毫秒
     */
    public static final long oneWeek_ms = 7 * oneDay_ms;
    /**
     * 1个月的毫秒数:31天*24小时*60分钟*60秒*1000毫秒
     */
    public static final long oneMonth_ms = 31 * oneDay_ms;

    private TimeUtils() {
        throw new AssertionError();
    }

    /**
     * long time to string
     *
     * @param timeInMillis
     * @param dateFormat
     * @return
     */
    public static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date(timeInMillis));
    }

    /**
     * long time to string, format is {@link #DEFAULT_DATE_FORMAT}
     *
     * @param timeInMillis
     * @return
     */
    public static String getTime(long timeInMillis) {
        return getTime(timeInMillis, DEFAULT_DATE_FORMAT);
    }

    /**
     * get current time in milliseconds
     *
     * @return
     */
    public static long getCurrentTimeInLong() {
        return System.currentTimeMillis();
    }

    /**
     * get current time in milliseconds, format is {@link #DEFAULT_DATE_FORMAT}
     *
     * @return
     */
    public static String getCurrentTimeInString() {
        return getTime(getCurrentTimeInLong());
    }

    /**
     * get current time in milliseconds
     *
     * @return
     */
    public static String getCurrentTimeInString(SimpleDateFormat dateFormat) {
        return getTime(getCurrentTimeInLong(), dateFormat);
    }

    public static boolean isToday(long when) {
        return DateUtils.isToday(when);
    }

    public static boolean isYesterday(long when) {
        Calendar c1 = Calendar.getInstance(); // today
        c1.add(Calendar.DAY_OF_YEAR, -1); // yesterday

        Calendar c2 = Calendar.getInstance();
        c2.setTime(new Date(when)); // your date

        if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
                && c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR)) {
            return true;
        }
        return false;
    }

    public static boolean isOutOfWeek(long when) {
        Calendar c1 = Calendar.getInstance(); // today
        c1.add(Calendar.DAY_OF_YEAR, -7); // yesterday

        Calendar c2 = Calendar.getInstance();
        c2.setTime(new Date(when)); // your date

        if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
                && c1.get(Calendar.DAY_OF_YEAR) > c2.get(Calendar.DAY_OF_YEAR)) {
            return true;
        }
        return false;
    }

    public static boolean isDateString(String dateStr) {
        try {
            Pattern p = Pattern.compile("^\\d{2}:\\d{2}$", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
            Matcher matcher = p.matcher(dateStr);
            if (matcher.find()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
