package com.vlocker.m;

import org.json.JSONArray;

public class ah extends JSONArray {
    public String join(String str) {
        int length = length();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(ai.b(get(i)));
        }
        return stringBuffer.toString();
    }

    public String toString() {
        try {
            return '[' + join(",") + ']';
        } catch (Exception e) {
            return null;
        }
    }
}
