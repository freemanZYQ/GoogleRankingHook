package com.vlocker.locker.d;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class c {
    private static String b = "UTF-8";
    protected ConcurrentHashMap a;

    public c() {
        c();
    }

    private void c() {
        this.a = new ConcurrentHashMap();
    }

    protected List a() {
        List linkedList = new LinkedList();
        for (Entry entry : this.a.entrySet()) {
            linkedList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        return linkedList;
    }

    public void a(String str, String str2) {
        if (str != null && str2 != null) {
            this.a.put(str, str2);
        }
    }

    public String b() {
        return URLEncodedUtils.format(a(), b);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : this.a.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append("=");
            stringBuilder.append((String) entry.getValue());
        }
        return stringBuilder.toString();
    }
}
