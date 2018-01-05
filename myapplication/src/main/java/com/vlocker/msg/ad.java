package com.vlocker.msg;

import android.content.pm.ResolveInfo;
import com.tencent.mm.sdk.constants.ConstantsAPI.WXApp;
import com.vlocker.c.a;
import com.vlocker.m.aj;
import java.util.ArrayList;
import java.util.Iterator;

class ad implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ ab b;

    ad(ab abVar, a aVar) {
        this.b = abVar;
        this.a = aVar;
    }

    public void run() {
        for (String a : new String[]{"com.tencent.mobileqq", WXApp.WXAPP_PACKAGE_NAME, "com.moxiu.launcher"}) {
            ArrayList a2 = aj.a(this.b.m, a);
            if (a2 != null) {
                Iterator it = a2.iterator();
                while (it.hasNext()) {
                    this.a.d((String) it.next(), true);
                }
            }
        }
        ResolveInfo a3 = ap.a(this.b.m, "mms");
        if (a3 != null) {
            this.a.d(as.a(a3.activityInfo.applicationInfo.packageName, a3.activityInfo.name), true);
        }
    }
}
