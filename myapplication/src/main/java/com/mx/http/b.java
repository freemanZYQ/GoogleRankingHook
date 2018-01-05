package com.mx.http;

import android.content.Context;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import com.baidu.location.LocationClientOption;
import com.mx.http.download.a;
import com.mx.http.download.i;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class b extends j {
    private a b;

    public b(String str, a aVar, Context context) {
        super(str, aVar);
        a = context;
        b(aVar);
        super.a(true);
    }

    private String a(Context context, boolean z) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Class cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = cls.getMethod("getPath", new Class[0]);
            Method method3 = cls.getMethod("isRemovable", new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i = 0; i < length; i++) {
                Object obj = Array.get(invoke, i);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (z == ((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        }
        return null;
    }

    private void b(a aVar) {
        String g;
        String str = null;
        if (TextUtils.isEmpty(aVar.g())) {
            aVar.e(com.mx.http.a.a.a(aVar.d()));
        }
        String c = aVar.c();
        switch (aVar.r()) {
            case 1:
                g = aVar.g();
                if (!".apk".equals(g)) {
                    str = !TextUtils.isEmpty(aVar.i()) ? aVar.c() + aVar.i() : c;
                    String str2 = a.t;
                    g = a.u;
                    c = str;
                    str = str2;
                    break;
                }
                try {
                    a(a, false) + "/moxiu/download/juhe/apk/file/";
                    g = "/moxiu/download/juhe/apk/temp/";
                    str = new StringBuilder(String.valueOf(a(a, false))).append(g);
                    str.toString();
                } catch (Exception e) {
                    str = e;
                    str.printStackTrace();
                } finally {
                    g = a.r;
                    g = a.s;
                }
                if (!TextUtils.isEmpty(aVar.j())) {
                    c = aVar.c();
                    break;
                }
                break;
            default:
                g = null;
                break;
        }
        aVar.c(Long.valueOf(System.currentTimeMillis()).intValue());
        aVar.a(c);
        aVar.k(str);
        aVar.l(g);
        aVar.a((int) LocationClientOption.MIN_SCAN_SPAN);
        aVar.d(new StringBuilder(String.valueOf(g)).append(c).append(aVar.g()).toString());
        aVar.m(new StringBuilder(String.valueOf(str)).append(c).append(".tmp").toString());
        aVar.a(i.UNKNOW);
        a(aVar);
    }

    public a a() {
        return this.b;
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    void a(i iVar) {
    }
}
