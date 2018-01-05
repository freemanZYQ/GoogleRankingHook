package com.b.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.moxiu.b.d.b;
import com.moxiu.b.d.c;
import com.moxiu.gdlibrary.GdtInitService;
import com.moxiu.gdlibrary.e;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class a {
    protected static void a(Context context) {
        try {
            c.a("DEBUG", "LOAD ASSET START-->" + System.currentTimeMillis());
            InputStream open = com.moxiu.b.d.a.b(context) ? context.getResources().getAssets().open("pid_t") : context.getResources().getAssets().open("pid");
            if (open != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = open.read();
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(read);
                }
                String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                if (byteArrayOutputStream2.length() > 10) {
                    JSONObject jSONObject = new JSONObject(byteArrayOutputStream2);
                    StringBuffer stringBuffer = new StringBuffer();
                    if (jSONObject.has("pid_arr")) {
                        JSONArray jSONArray = jSONObject.getJSONArray("pid_arr");
                        if (jSONArray != null && jSONArray.length() > 0) {
                            b.b(context);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                                String optString = jSONObject2.optString("key", "");
                                String optString2 = jSONObject2.optString("pid", "");
                                if (!(TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2))) {
                                    b.a(context, optString, optString2);
                                    stringBuffer.append(optString2);
                                }
                                if (i != jSONArray.length() - 1) {
                                    stringBuffer.append(",");
                                }
                            }
                            b.c(context, stringBuffer.toString());
                        }
                    }
                    b.c(context);
                    if (c.i(context).booleanValue()) {
                        a(context, "ade", jSONObject);
                    }
                    if (c.i(context).booleanValue() && c.j(context).booleanValue()) {
                        a(context, "baidu", jSONObject);
                    }
                    a(context, "dianou", jSONObject);
                }
            }
            c.a("DEBUG", "LOAD ASSET END-->" + System.currentTimeMillis());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(Context context, String str) {
        int k = c.k(context);
        if (b.a(context) != k) {
            b.f(context, str);
            com.moxiu.b.d.a.a(context);
            Thread bVar = new b(context);
            bVar.setDaemon(true);
            bVar.start();
            try {
                if ("com.moxiu.launcher".equals(context.getPackageName()) && c.i(context).booleanValue()) {
                    context.startService(new Intent(context, GdtInitService.class));
                }
            } catch (Exception e) {
            } catch (Error e2) {
            }
            b.a(context, k);
        }
    }

    private static void a(Context context, String str, JSONObject jSONObject) {
        if (jSONObject.has(str)) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                if (jSONObject2 != null && jSONObject2.length() > 0) {
                    b.b(context, str, jSONObject2.optString("aid", ""));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static String b(Context context, String str) {
        return b.a(context, str);
    }

    public static com.moxiu.b.a.a c(Context context, String str) {
        String b = b.b(context, str);
        return TextUtils.isEmpty(b) ? null : "ade".equals(str) ? new e(b) : "baidu".equals(str) ? new com.moxiu.a.a(b) : "dianou".equals(str) ? new com.b.a.a() : null;
    }
}
