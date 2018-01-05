package com.vlocker.f;

import android.content.Context;
import android.os.Build.VERSION;
import com.vlocker.c.a;
import com.vlocker.theme.f.b;

public class g {
    public static h a() {
        return new o();
    }

    public static m a(Context context) {
        if (a.a(context).ch()) {
            if (com.vlocker.f.a.a.a()) {
                j.d = "saumang1";
            } else {
                j.d = "saumang2";
            }
            return new ai(context);
        }
        if (b.e()) {
            if (VERSION.SDK_INT >= 23 && ab.b(context)) {
                j.d = com.vlocker.f.a.a.c();
                return new ab(context);
            } else if (VERSION.SDK_INT >= 21 && t.e()) {
                j.d = com.vlocker.f.a.a.c();
                return new t(context);
            }
        } else if (ab.b(context) && com.vlocker.f.a.a.c() != null) {
            j.d = com.vlocker.f.a.a.c();
            return new ab(context);
        }
        return null;
    }
}
