package com.vlocker.search;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

final class aq implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ Context g;

    aq(String str, String str2, String str3, String str4, String str5, String str6, Context context) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = context;
    }

    public void run() {
        try {
            List linkedList = new LinkedList();
            linkedList.add(new BasicNameValuePair("word", this.a));
            linkedList.add(new BasicNameValuePair("mobile", this.b));
            linkedList.add(new BasicNameValuePair("from", this.c));
            linkedList.add(new BasicNameValuePair("engine", this.d));
            linkedList.add(new BasicNameValuePair("target", this.e));
            linkedList.add(new BasicNameValuePair("source", this.f));
            ap.a(this.g, ap.g, linkedList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
