package com.alimama.ad.mobile.a;

import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class a {
    public static String a = "Reflector";

    public static Class a(String str) {
        Class cls = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                cls = Class.forName(str);
            } catch (Exception e) {
                Log.e(a, "Get class failed,ex:" + e.toString());
            }
        }
        return cls;
    }

    public static Method a(Object obj, String str, Class[] clsArr) {
        if (!(obj == null || TextUtils.isEmpty(str))) {
            try {
                return obj.getClass().getDeclaredMethod(str, clsArr);
            } catch (Exception e) {
                Log.e(a, "Get class method failed,ex:" + e.toString());
            }
        }
        return null;
    }

    public static void a(Object obj, Method method, Object[] objArr) {
        if (method != null && obj != null) {
            try {
                method.invoke(obj, objArr);
            } catch (Exception e) {
                Log.e(a, "Do void method failed,ex:" + e.toString());
            }
        }
    }

    public static Object b(String str) {
        Object obj = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                Class cls = Class.forName(str);
                Constructor declaredConstructor = cls != null ? cls.getDeclaredConstructor(new Class[0]) : null;
                if (declaredConstructor != null) {
                    declaredConstructor.setAccessible(true);
                    obj = declaredConstructor.newInstance(new Object[0]);
                }
            } catch (Exception e) {
                Log.e(a, "Get class object failed,ex:" + e.toString());
            }
        }
        return obj;
    }

    public static boolean b(Object obj, Method method, Object[] objArr) {
        if (!(method == null || obj == null)) {
            try {
                return ((Boolean) method.invoke(obj, objArr)).booleanValue();
            } catch (Exception e) {
                Log.e(a, "Do boolean method failed,ex:" + e.toString());
            }
        }
        return false;
    }
}
