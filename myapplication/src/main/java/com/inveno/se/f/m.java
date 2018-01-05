package com.inveno.se.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;

public class m {
    public static Context a(Context context) {
        try {
            Context createPackageContext = context.createPackageContext(d.a, 2);
            return createPackageContext == null ? context : createPackageContext;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            a.a("hzj", "getPackageContext:" + null + " c:" + context + " ex:" + e.getMessage());
            return context == null ? context : context;
        } catch (Exception e2) {
            a.a("hzj", "getPackageContext:" + null + " c:" + context + " ex:" + e2.getMessage());
            return context == null ? context : context;
        } catch (Throwable th) {
            if (null == null) {
                return context;
            }
        }
    }

    public static void a(String str, String str2, Context context) {
        Context a = a(context);
        if (a == null) {
            a.a("hzj", "setInformain, get context = null");
            return;
        }
        SharedPreferences sharedPreferences = a.getSharedPreferences("settings", 0);
        a.a("hzj", "setInformain settings:" + sharedPreferences);
        Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public static String b(String str, String str2, Context context) {
        Context a = a(context);
        if (a == null) {
            a.a("hzj", "getInformain, get context = null");
        } else {
            SharedPreferences sharedPreferences = a.getSharedPreferences("settings", 0);
            a.a("hzj", "getInformain settings:" + sharedPreferences);
            try {
                str2 = sharedPreferences.getString(str, str2);
            } catch (ClassCastException e) {
                a.a("hzj", "String getInformain error Key:" + str + " e:" + e.getMessage());
            }
        }
        return str2;
    }
}
