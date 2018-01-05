package com.vlocker.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.mx.http.a.d;
import com.mx.http.download.DownloadService;
import com.mx.http.download.i;
import com.vlocker.locker.R;
import com.vlocker.m.aj;
import com.vlocker.m.r;
import com.vlocker.msg.ao;
import com.vlocker.theme.f.e;
import com.vlocker.ui.cover.f;
import com.vlocker.weather.y;
import java.util.Map;

public class a {
    private static void a() {
        r.a().a(17, new d());
    }

    public static void a(Context context) {
        Map a = d.a(context);
        if (a != null && a.size() > 0) {
            for (String a2 : a.keySet()) {
                try {
                    com.mx.http.download.a aVar = (com.mx.http.download.a) d.a(context, a2, com.mx.http.download.a.class);
                    if (aVar != null && i.DOWNLOADING.equals(aVar.b())) {
                        Intent intent = new Intent(context, DownloadService.class);
                        intent.putExtras(new Bundle());
                        context.startService(intent);
                        return;
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    private static boolean a(Context context, com.moxiu.b.a.a aVar) {
        return "taobao".equals(aVar.s()) && j.a(context, "com.taobao.taobao") && aj.b(context, "com.taobao.taobao") >= 123;
    }

    public static boolean a(Context context, com.moxiu.b.a.a aVar, View view, String str, com.vlocker.weather.a aVar2, boolean z, y yVar) {
        if (context == null || aVar == null || view == null) {
            return false;
        }
        try {
            if (!e.c(context)) {
                e.a(context, context.getString(R.string.M_bd_net_set), 0);
                return false;
            } else if (!z || e.b(context).booleanValue() || !aVar.f() || aVar2 == null || yVar == null) {
                try {
                    if (!aVar.f() && "baidu".equals(aVar.C) && f.e) {
                        aVar.a(view);
                        a();
                        return true;
                    } else if (!a(context, aVar) || view == null) {
                        aVar.a(view);
                        if ("dianou".equals(aVar.C) && "nothing".equals(aVar.s()) && ("rc".equals(aVar.D) || "url".equals(aVar.D))) {
                            return b(context, aVar, str, aVar2);
                        }
                        return false;
                    } else {
                        aVar2.a(16, new c(aVar, view, context, str, aVar2));
                        return true;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    return b(context, aVar, str, aVar2);
                }
            } else {
                aVar2.a(15, new b(context, aVar, yVar));
                return true;
            }
        } catch (Exception e) {
        }
    }

    private static boolean b(Context context, com.moxiu.b.a.a aVar, String str, com.vlocker.weather.a aVar2) {
        if (!"dianou".equals(aVar.C)) {
            return false;
        }
        if ("rc".equals(aVar.D) || "url".equals(aVar.D)) {
            if (aVar2 != null) {
                aVar2.a(5, new e(context, aVar, str));
            } else {
                Intent a = ao.a(context, aVar.i());
                a.putExtra("tag", str);
                a.addFlags(268435456);
                context.startActivity(a);
            }
        }
        return true;
    }
}
