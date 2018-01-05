package com.vlocker.e;

import android.content.Context;
import android.text.TextUtils;
import com.vlocker.b.i;
import com.vlocker.b.o;
import com.vlocker.b.p;
import com.vlocker.battery.clean.a;
import com.vlocker.battery.clean.y;
import com.vlocker.security.MoSecurityApplication;
import java.util.HashMap;

public class j {
    private static j a;
    private static HashMap b;
    private static l c = null;
    private Context d = MoSecurityApplication.a();

    private j() {
        b = new HashMap();
        c = new k(this);
    }

    public static j a() {
        if (a == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new j();
                }
            }
        }
        return a;
    }

    private d d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d dVar;
        if (str.equals("1")) {
            dVar = new d();
            dVar.f(com.vlocker.b.j.a());
            dVar.h(i.g);
            dVar.i("vlocker_launcher");
        } else {
            dVar = null;
        }
        if (str.equals("2")) {
            a a = y.a().a(false);
            if (a == null) {
                return null;
            }
            dVar = new d();
            dVar.g(a.e);
            dVar.h(i.g);
            dVar.i(a.d + "_" + a.h);
            dVar.a(a.d);
        }
        return dVar;
    }

    public void a(String str) {
        if (com.vlocker.b.j.b(this.d) == o.wifiNetStatus && !b(str)) {
            d d = d(str);
            if (d != null) {
                if ("1" == str) {
                    p.a(this.d, "Vlocker_Pre_Download_Moxiu_PPC_TF", new String[0]);
                }
                o oVar = new o(c, d, str);
                b.put(str, oVar);
                oVar.start();
            }
        }
    }

    public boolean b(String str) {
        return b.get(str) != null;
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            o oVar = (o) b.get(str);
            if (oVar != null && oVar.isAlive()) {
                oVar.a();
            }
            b.remove(str);
        }
    }
}
