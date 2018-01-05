package com.c.a.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.c.a.a.b;
import com.c.a.a.d;
import com.c.a.a.e;
import com.c.a.c;

public class a {
    private static d a(com.c.a.g.a aVar) {
        return aVar == null ? null : aVar.c == com.c.a.a.a.AUTH ? new b(aVar.d) : aVar.c == com.c.a.a.a.JUMP ? new e() : null;
    }

    private static boolean a(Context context, Intent intent, d dVar) {
        return b(context, intent, dVar);
    }

    private static boolean a(Context context, com.c.a.g.a aVar, d dVar, c cVar) {
        Intent intent = new Intent("android.intent.action.VIEW");
        switch (b.a[cVar.ordinal()]) {
            case 1:
                intent.setData(Uri.parse("http://huodong.m.taobao.com/go/2085.html"));
                if (com.c.a.i.a.a() != null) {
                    com.c.a.i.a.a().b("0");
                    break;
                }
                break;
            case 2:
                if (com.c.a.i.a.a() != null) {
                    com.c.a.i.a.a().b("1");
                }
                if (!com.c.a.k.c.a(aVar.a())) {
                    intent.setData(Uri.parse(aVar.a()));
                    break;
                }
                return false;
            case 3:
                if (com.c.a.i.a.a() == null) {
                    return false;
                }
                com.c.a.i.a.a().b("2");
                return false;
        }
        return b(context, intent, dVar);
    }

    public static boolean a(Context context, com.c.a.g.a aVar, com.c.a.f.a.a aVar2) {
        if (context == null || aVar == null) {
            return false;
        }
        d a = a(aVar);
        a.b(context, aVar2);
        if (a == null) {
            return false;
        }
        c cVar = com.c.a.b.a().b;
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(aVar.b(context)));
        intent.setAction("com.taobao.open.intent.action.GETWAY");
        intent.setFlags(805339136);
        return com.c.a.k.d.a(context) ? a(context, intent, a) : a(context, aVar, a, cVar);
    }

    private static boolean b(Context context, Intent intent, d dVar) {
        if (context == null || intent == null || dVar == null) {
            return false;
        }
        try {
            context.startActivity(intent);
            dVar.a();
            return true;
        } catch (Exception e) {
            dVar.a(e);
            return false;
        }
    }
}
