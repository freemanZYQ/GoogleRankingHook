package com.c.a.k;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import com.c.a.b.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class d {
    private static Application a;

    public static synchronized Application a() {
        Application application;
        synchronized (d.class) {
            if (a == null) {
                a = b();
            }
            application = a;
        }
        return application;
    }

    public static boolean a(Context context) {
        boolean z = false;
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("tbopen://m.taobao.com/tbopen/index.html?"));
        intent.setAction("com.taobao.open.intent.action.GETWAY");
        try {
            if (packageManager.getPackageInfo("com.taobao.taobao", 0) != null && packageManager.queryIntentActivities(intent, 65536).size() > 0) {
                String c = a.c(context);
                if (!c.a(c)) {
                    z = c.a(c, "5.2.0");
                }
            }
        } catch (Exception e) {
            Log.d("AppLink", e.toString());
        }
        return z;
    }

    private static Application b() {
        try {
            Class cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            Field declaredField = cls.getDeclaredField("mInitialApplication");
            declaredField.setAccessible(true);
            return (Application) declaredField.get(declaredMethod.invoke(null, new Object[0]));
        } catch (Exception e) {
            Log.d("AppLink", e.toString());
            return null;
        }
    }
}
