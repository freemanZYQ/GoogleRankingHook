package com.c.a.k;

import android.util.Log;
import java.security.MessageDigest;

public class a {
    public static String a(String str) {
        String str2 = null;
        if (!c.a(str)) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(str.getBytes());
                StringBuffer stringBuffer = new StringBuffer();
                byte[] digest = instance.digest();
                for (int i : digest) {
                    int i2;
                    if (i2 < 0) {
                        i2 += 256;
                    }
                    if (i2 < 16) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(Integer.toHexString(i2));
                }
                str2 = stringBuffer.toString();
            } catch (Throwable th) {
                Log.d("AppLink", th.toString());
            }
        }
        return str2;
    }
}
