package com.b.d;

import android.content.Context;
import android.text.TextUtils;
import com.b.f.a;
import com.moxiu.b.c.r;
import com.moxiu.b.d.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class c {
    private static long a = 0;

    public static List a(Context context, String str, String str2, int i) {
        List arrayList = new ArrayList();
        Object g = b.g(context, str);
        if (!TextUtils.isEmpty(g)) {
            try {
                JSONObject jSONObject = new JSONObject(g);
                Integer.parseInt(jSONObject.getString("code"));
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (!jSONObject2.isNull(str2)) {
                    arrayList = a.a(context, jSONObject2.getJSONObject(str2), str2, i);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return arrayList;
    }

    public static void a(Context context) {
        String d = b.d(context);
        try {
            if (d.length() >= 5) {
                new r().a(com.moxiu.b.d.c.b(context, d), new d(context));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
