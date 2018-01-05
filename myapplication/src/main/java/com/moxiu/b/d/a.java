package com.moxiu.b.d;

import android.content.Context;
import java.lang.reflect.Field;

public class a {
    public static void a(Context context) {
        boolean z;
        Exception e;
        boolean z2 = false;
        boolean z3;
        try {
            Class cls = Class.forName(context.getPackageName() + ".BuildConfig");
            Field declaredField = cls.getDeclaredField("ENVIRONMENT_TYPE");
            Field declaredField2 = cls.getDeclaredField("AD_ENVIRONMENT_TYPE");
            if (declaredField != null) {
                z3 = !declaredField.getBoolean(cls);
            } else {
                z3 = false;
            }
            if (declaredField2 != null) {
                try {
                    z = !declaredField2.getBoolean(cls);
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    z = false;
                    z2 = true;
                    b.a(context, z2);
                }
                if (z3 || r0) {
                    z2 = true;
                }
                b.a(context, z2);
            }
        } catch (Exception e3) {
            e = e3;
            z3 = false;
            e.printStackTrace();
            z = false;
            z2 = true;
            b.a(context, z2);
        }
        z = false;
        z2 = true;
        b.a(context, z2);
    }

    public static boolean b(Context context) {
        return b.f(context);
    }

    public static String c(Context context) {
        return b(context) ? "http://e.dianou.test.imoxiu.cn/json.php?do=Conf.Get" : "http://e.dianou.com/json.php?do=Conf.Get";
    }

    public static String d(Context context) {
        return b(context) ? "http://e.dianou.test.imoxiu.cn/json.php?do=Conf.Multi.Get" : "http://e.dianou.com/json.php?do=Conf.Multi.Get";
    }

    public static String e(Context context) {
        return b(context) ? "http://e.dianou.test.imoxiu.cn/json.php?do=Conf.Pre.Get" : "http://e.dianou.com/json.php?do=Conf.Pre.Get";
    }

    public static String f(Context context) {
        return b(context) ? "http://e.dianou.test.imoxiu.cn/api.php?do=Collect.Show" : "http://e.dianou.com/api.php?do=Collect.Show";
    }

    public static String g(Context context) {
        return b(context) ? "http://e.dianou.test.imoxiu.cn/api.php?do=Collect.Click" : "http://e.dianou.com/api.php?do=Collect.Click";
    }

    public static String h(Context context) {
        return b(context) ? "http://e.dianou.test.imoxiu.cn/api.php?do=Collect.Download" : "http://e.dianou.com/api.php?do=Collect.Download";
    }

    public static String i(Context context) {
        return b(context) ? "http://e.dianou.test.imoxiu.cn/api.php?do=Collect.Install" : "http://e.dianou.com/api.php?do=Collect.Install";
    }
}
