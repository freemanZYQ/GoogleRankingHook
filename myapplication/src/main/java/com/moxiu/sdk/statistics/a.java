package com.moxiu.sdk.statistics;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.moxiu.sdk.statistics.e.f;
import com.moxiu.sdk.statistics.manager.h;
import java.util.LinkedHashMap;

public class a {
    public static void a(Application application, String str) {
        if (application == null || TextUtils.isEmpty(str)) {
            Log.e("MxStatAgent", "init params error!");
        }
        h.a().a(application);
        b.c = str;
    }

    public static void a(String str, String str2) {
        b.a = str;
        b.b = str2;
    }

    public static void a(String str, LinkedHashMap linkedHashMap) {
        a(str, linkedHashMap, f.normal);
    }

    public static void a(String str, LinkedHashMap linkedHashMap, f fVar) {
        h.a().a(str, linkedHashMap, fVar);
    }

    public static void a(boolean z) {
        b.e = z;
    }

    public static void b(boolean z) {
        b.d = z;
    }
}
