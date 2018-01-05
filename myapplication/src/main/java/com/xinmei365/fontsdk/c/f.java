package com.xinmei365.fontsdk.c;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class f {
    public static String A(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            for (int i : instance.digest()) {
                int i2;
                if (i2 < 0) {
                    i2 += 256;
                }
                if (i2 < 16) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(Integer.toHexString(i2));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
