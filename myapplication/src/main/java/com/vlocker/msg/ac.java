package com.vlocker.msg;

import android.content.pm.ResolveInfo;
import com.vlocker.c.a;
import com.vlocker.m.aj;
import com.vlocker.msg.data.c;
import com.vlocker.security.MoSecurityApplication;
import java.util.ArrayList;
import java.util.Iterator;

class ac implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ ab b;

    ac(ab abVar, a aVar) {
        this.b = abVar;
        this.a = aVar;
    }

    public void run() {
        synchronized (this.b.i) {
            for (String a : MoSecurityApplication.a ? c.b : c.a) {
                String a2;
                ArrayList a3 = aj.a(this.b.m, a2);
                if (a3 != null) {
                    Iterator it = a3.iterator();
                    while (it.hasNext()) {
                        this.a.c((String) it.next(), true);
                    }
                }
            }
            ResolveInfo a4 = ap.a(this.b.m, "phone");
            if (a4 != null) {
                String str = a4.activityInfo.applicationInfo.packageName;
                a2 = a4.activityInfo.name;
                this.a.u(as.a(str, a2));
                this.a.c(as.a(str, a2), true);
            }
            a4 = ap.a(this.b.m, "mms");
            if (a4 != null) {
                str = a4.activityInfo.applicationInfo.packageName;
                a2 = a4.activityInfo.name;
                this.a.c(as.a(str, a2), true);
                this.a.v(as.a(str, a2));
            }
            this.b.c();
            this.b.b = true;
        }
    }
}
