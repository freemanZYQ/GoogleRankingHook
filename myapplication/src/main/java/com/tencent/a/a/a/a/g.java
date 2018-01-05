package com.tencent.a.a.a.a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class g {
    private static g d = null;
    private Map a = null;
    private int b = 0;
    private Context c = null;

    private g(Context context) {
        this.c = context.getApplicationContext();
        this.a = new HashMap(3);
        this.a.put(Integer.valueOf(1), new e(context));
        this.a.put(Integer.valueOf(2), new b(context));
        this.a.put(Integer.valueOf(4), new d(context));
    }

    private c a(List list) {
        if (list != null && list.size() >= 0) {
            for (Integer num : list) {
                f fVar = (f) this.a.get(num);
                if (fVar != null) {
                    c c = fVar.c();
                    if (c != null && h.b(c.c)) {
                        return c;
                    }
                }
            }
        }
        return new c();
    }

    public static synchronized g a(Context context) {
        g gVar;
        synchronized (g.class) {
            if (d == null) {
                d = new g(context);
            }
            gVar = d;
        }
        return gVar;
    }

    public final c a() {
        return a(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4)})));
    }

    public final void a(String str) {
        c a = a();
        a.c = str;
        if (!h.a(a.a)) {
            a.a = h.a(this.c);
        }
        if (!h.a(a.b)) {
            a.b = h.b(this.c);
        }
        a.d = System.currentTimeMillis();
        for (Entry value : this.a.entrySet()) {
            ((f) value.getValue()).a(a);
        }
    }
}
