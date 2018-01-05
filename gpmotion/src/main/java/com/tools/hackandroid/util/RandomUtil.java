package com.tools.hackandroid.util;

import android.text.TextUtils;

import java.util.Random;

/**
 * @author zhitao
 * @since 2016-04-19 15:21
 */
public class RandomUtil {

    /**
     * 数字
     */
    public final static String NUMBER_STRING = "0123456789";

    /**
     * 大写字母
     */
    public final static String UPPER_CASE_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 小写字母
     */
    public final static String LOWER_CASE_STRING = "abcdefghijklmnopqrstuvwxyz";

    /**
     * 常用符号
     */
    public final static String NORMAL_SYMBOL_STRING = "~!@#$%^&*_+-=/?";//`;':"|\,.

    /**
     * 括号
     */
    public final static String BRACKET_STRING = "()[]{}<>";

    /**
     * 生成一个随机字符串
     *
     * @param srcStringSet 随机字符串的内容源
     * @param length       生成的随机字符串长度
     * @return
     */
    public static String newRandomString(String srcStringSet, int length) {
        if (TextUtils.isEmpty(srcStringSet)) {
            throw new IllegalArgumentException();
        }
        char[] srcCharArray = srcStringSet.toCharArray();
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(srcCharArray[random.nextInt(srcCharArray.length)]);
        }
        return sb.toString();
    }

    /**
     * 生成有字母数字符号的随机字符串
     *
     * @param length 随机字符串长度
     * @return
     */
    public static String newRandomCaseAndSymbolString(int length) {
        return newRandomString(NUMBER_STRING + LOWER_CASE_STRING + UPPER_CASE_STRING + NORMAL_SYMBOL_STRING, length);
    }

    /**
     * 生成随机数字字符串
     *
     * @param length 随机字符串长度
     * @return
     */
    public static String newRandomNumberString(int length) {
        return newRandomString(NUMBER_STRING, length);
    }

    public static int getRandomNumber(int min, int max) {
        if (min > max) {
            return 0;
        }
        if (min == max) {
            return min;
        }
        return min + new Random().nextInt(max - min);

    }

}
