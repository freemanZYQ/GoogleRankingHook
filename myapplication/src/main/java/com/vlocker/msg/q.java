package com.vlocker.msg;

import android.app.NotificationManager;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.vlocker.b.p;
import com.vlocker.battery.saver.b;
import com.vlocker.locker.R;
import mcm.sdk.a;

class q implements e {
    final /* synthetic */ p a;

    q(p pVar) {
        this.a = pVar;
    }

    public void a(float f, String str) {
        this.a.h.a(f, this.a.c(str));
    }

    public void a(float f, boolean z) {
        this.a.h.a(f, z);
    }

    public void a(String str) {
        p.a(this.a.f, "v_delete", "101000", "101001", "1015");
        ak c = this.a.c(str);
        if (c != null) {
            if (c.r) {
                a.b(this.a.f, c.q, "2.2");
            }
            if ("mx_ad".equals(str)) {
                b.a(this.a.f).a(c, "ad_delete");
                b.a(this.a.f).c();
                b.a(this.a.f).b(true);
                Toast.makeText(this.a.f, this.a.f.getString(R.string.battery_remove_ad_toast), 1).show();
            }
            if (str.startsWith("msg_ad")) {
                com.vlocker.msg.a.a.a(this.a.f).b();
            }
        }
        ab.a().d(str);
        this.a.g.a(str);
        if (str.startsWith(this.a.f.getPackageName() + "|")) {
            ((NotificationManager) this.a.f.getSystemService("notification")).cancel(as.b(str));
        }
        Intent intent = new Intent();
        intent.putExtra("pakName", str);
        intent.setAction("com.vlocker.locker.cleanNotification");
        this.a.f.sendBroadcast(intent);
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            ak c = this.a.c(str);
            if (c != null) {
                p.a(this.a.f, "v_open", "101000", "101001", "1015");
                if (c == null || c.F != 8) {
                    this.a.h.a(new l(this.a.f, c, this.a.e.getMsgTouchView(), "locker"), c);
                    return;
                }
                int b = as.b(c.b);
                as.a(this.a.f, b);
                ab.e(this.a.f.getPackageName() + "|" + c.F + "|" + b);
                p.a(this.a.f, "Vlocker_Open_PushMessage_PPC_TF", "location", "Locker", "name", "weather alarm");
                ao.e(this.a.f, c.D);
            }
        }
    }
}
