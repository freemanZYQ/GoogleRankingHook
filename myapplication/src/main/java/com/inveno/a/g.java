package com.inveno.a;

import android.text.TextUtils;
import com.inveno.se.f.a;
import com.inveno.se.f.k;
import java.util.HashMap;
import java.util.Map;

public class g {
    private static g a;
    private au b = new t();
    private ah c = ah.a();

    private g() {
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (a == null) {
                a = new g();
            }
            gVar = a;
        }
        return gVar;
    }

    private void b(String str, Map map, ai aiVar) {
        this.b.a(str, map, new h(this, str, aiVar));
    }

    public void a(ai aiVar) {
        Map hashMap = new HashMap(l.a().C());
        String str = (String) hashMap.get("data");
        if (k.a(str)) {
            str = "";
        }
        hashMap.put("tk", com.inveno.se.f.g.a(m.b + ":" + str + ":" + hashMap.get("request_time")));
        b(this.c.m, hashMap, aiVar);
    }

    void a(au auVar) {
        if (auVar == null) {
            a.a("DataSDK", "requestTool should not be null!");
        } else {
            this.b = auVar;
        }
    }

    public void a(String str, int i, int i2, int i3, int i4, ai aiVar, int i5) {
        CharSequence A = l.a().A();
        if (!TextUtils.isEmpty(A)) {
            if (ag.a().b()) {
                i5 = 1;
            }
            Map hashMap = new HashMap(i.a());
            hashMap.put("uid", A);
            hashMap.put("operation", String.valueOf(i5));
            hashMap.put("scenario", str);
            hashMap.put("count", String.valueOf(i));
            hashMap.put("content_type", a.g.a(i2, 8));
            hashMap.put("display", a.g.a(i3, 8));
            hashMap.put("link_type", a.g.a(i4, 8));
            hashMap.put("mode", String.valueOf(l.a().z()));
            b(this.c.n, hashMap, aiVar);
        } else if (aiVar != null) {
            aiVar.a("没有Uid");
        }
    }

    public void a(String str, Map map, ai aiVar) {
        this.b.a(str, map, aiVar);
    }
}
