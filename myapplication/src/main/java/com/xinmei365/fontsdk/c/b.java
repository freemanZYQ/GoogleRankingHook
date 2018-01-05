package com.xinmei365.fontsdk.c;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONException;

public class b {
    public static JSONArray a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        JSONArray jSONArray;
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < strArr.length; i++) {
            stringBuilder.append("\"").append(strArr[i]).append("\"");
            if (i != strArr.length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        try {
            jSONArray = new JSONArray(stringBuilder.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            jSONArray = null;
        }
        return jSONArray;
    }

    public static byte[] a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = Long.valueOf(255 & j).byteValue();
            j >>= 8;
        }
        return bArr;
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static String[] a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            try {
                strArr[i] = jSONArray.getString(i);
            } catch (JSONException e) {
                strArr[i] = "";
            }
        }
        return strArr;
    }

    public static long b(byte[] bArr) {
        long j = ((long) (bArr[0] & 255)) | (((long) (bArr[1] & 255)) << 8);
        j |= ((long) (bArr[2] & 255)) << 16;
        j |= ((long) (bArr[3] & 255)) << 24;
        j |= ((long) (bArr[4] & 255)) << 32;
        j |= ((long) (bArr[5] & 255)) << 40;
        return (j | (((long) (bArr[6] & 255)) << 48)) | (((long) (bArr[7] & 255)) << 56);
    }
}
