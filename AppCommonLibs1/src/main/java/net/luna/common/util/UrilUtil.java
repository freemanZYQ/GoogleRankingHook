package net.luna.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by bintou on 15/11/27.
 */
public class UrilUtil {

    /**
     * 获取URL中的拼接参数
     *
     * @param url
     * @return
     */
    public static String getQueryString(String url, String paras) {
        try {
            String parasAry[] = url.substring(url.indexOf("?") + 1).split("&");
            for (String temp : parasAry) {
                String tempParas = temp.substring(0, temp.indexOf("=")).toLowerCase();
                if (tempParas.equals(paras.toLowerCase())) {
                    return temp.substring(temp.indexOf("=") + 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getVal(String body, String pattern) {
        String result = "";
        try {
            if (body != null) {
                body = body.replaceAll(" ", "");
                String vidRegex = pattern;
                Pattern p = Pattern.compile(vidRegex);
                Matcher m = p.matcher(body);
                if (m.find()) {
                    result = m.group(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
