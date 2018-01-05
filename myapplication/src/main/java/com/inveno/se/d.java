package com.inveno.se;

import android.content.Context;
import com.inveno.a.f;
import com.inveno.se.c.a;
import com.inveno.se.e.c;

public class d {
    private static d a;
    private final a b;
    private c c;

    private d(Context context) {
        this.b = a.a(context);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d(context);
            }
            dVar = a;
        }
        return dVar;
    }

    private void b(Context context, String str, int i, int i2, int i3, int i4, com.inveno.se.e.a aVar, int i5) {
        try {
            f.a(str, i, i2, i3, i4, new f(this, aVar, context), i5);
        } catch (Exception e) {
            com.inveno.se.f.a.a("pise", "getNews error:" + e.getMessage());
        }
    }

    public void a(Context context, String str, int i, int i2, int i3, int i4, com.inveno.se.e.a aVar, int i5) {
        if (this.b.a()) {
            b(context, str, i, i2, i3, i4, aVar, i5);
            return;
        }
        this.c = new e(this, context, str, i, i2, i3, i4, aVar, i5);
        this.b.a(this.c, context);
    }
}
