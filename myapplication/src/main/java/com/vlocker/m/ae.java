package com.vlocker.m;

import java.security.MessageDigest;

public class ae {
    public static String a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            return a(instance.digest());
        } catch (Exception e) {
            return null;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        String str = "0123456789abcdef";
        int length = bArr.length;
        StringBuilder stringBuilder = new StringBuilder(length * 2);
        for (int i = 0; i < length; i++) {
            stringBuilder.append("0123456789abcdef".charAt((bArr[i] & 240) >>> 4));
            stringBuilder.append("0123456789abcdef".charAt(bArr[i] & 15));
        }
        return stringBuilder.toString();
    }
}
