package com.vlocker.l;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.view.View;
import com.vlocker.b.p;
import com.vlocker.locker.R;

class s extends ad {
    aj a;
    String b;
    final /* synthetic */ j c;

    public s(j jVar, View view) {
        this.c = jVar;
        super(jVar);
        this.b = null;
        this.d = new Intent();
        this.d.setAction("android.intent.action.SET_ALARM");
        this.d.addFlags(268435456);
        ResolveInfo resolveActivity = jVar.b.getPackageManager().resolveActivity(this.d, 0);
        if (resolveActivity != null && resolveActivity.activityInfo != null) {
            String str = resolveActivity.activityInfo.packageName;
            if (!TextUtils.isEmpty(str) && !str.equals("android")) {
                this.b = str;
                this.a = new aj(jVar.b, str);
            }
        }
    }

    void a() {
        a(this.c.b.getString(R.string.toast_error_alarm));
    }

    void b() {
        p.a(this.c.b, "Vlocker_Click_Alarm_PPC_TF", new String[0]);
        this.c.r.a(new t(this), (byte) 2);
    }
}
