package com.moxiu.sdk.statistics.c;

import android.content.Context;
import com.moxiu.sdk.statistics.d.b;
import com.moxiu.sdk.statistics.d.d;
import com.moxiu.sdk.statistics.d.e;
import com.moxiu.sdk.statistics.d.f;
import com.moxiu.sdk.statistics.e.g;
import com.moxiu.sdk.statistics.e.i;
import com.moxiu.sdk.statistics.manager.h;
import java.util.LinkedHashMap;

public class a implements b {
    public String a;
    public LinkedHashMap b;
    private String c = "event";
    private String d = "astrology";

    private f a(Context context) {
        f fVar = new f();
        fVar.b = d();
        fVar.c = b(context);
        i.a("getMessageData data = " + fVar.toString());
        return fVar;
    }

    private e[] a(LinkedHashMap linkedHashMap) {
        e[] eVarArr = new e[linkedHashMap.size()];
        int i = 0;
        for (String str : linkedHashMap.keySet()) {
            e eVar = new e();
            eVar.b = com.moxiu.sdk.statistics.e.a.a(str);
            eVar.c = com.moxiu.sdk.statistics.e.a.a((String) linkedHashMap.get(str));
            eVarArr[i] = eVar;
            i++;
        }
        return eVarArr;
    }

    private b b(Context context) {
        return new com.moxiu.sdk.statistics.e.a(context).a();
    }

    private d d() {
        d dVar = new d();
        dVar.b = com.moxiu.sdk.statistics.e.a.a(this.c);
        dVar.c = com.moxiu.sdk.statistics.e.a.a(this.d);
        dVar.d = com.moxiu.sdk.statistics.e.a.a(this.a);
        dVar.e = a(this.b);
        dVar.f = com.moxiu.sdk.statistics.e.a.a("");
        return dVar;
    }

    public byte[] a() {
        Context b = h.a().b();
        if (this.b == null) {
            this.b = new LinkedHashMap();
        }
        byte[] bArr = null;
        try {
            bArr = com.moxiu.sdk.a.a.d.a(a(b));
        } catch (Throwable e) {
            i.a("getSerData Exception = ", e);
        }
        return bArr;
    }

    public int b() {
        return g.astrology_pb.a();
    }

    public String c() {
        return null;
    }
}
