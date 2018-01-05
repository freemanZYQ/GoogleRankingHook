package com.vlocker.msg;

import android.content.pm.PackageManager.NameNotFoundException;
import android.database.ContentObserver;
import android.os.Handler;
import com.vlocker.c.a;
import com.vlocker.locker.R;
import com.vlocker.m.b;
import com.vlocker.m.z;
import com.vlocker.ui.cover.LockerService;
import java.util.Date;

class g extends ContentObserver {
    final /* synthetic */ f a;

    public g(f fVar, Handler handler) {
        this.a = fVar;
        super(handler);
    }

    public void onChange(boolean z) {
        int a = b.a(this.a.b);
        if (a.a(this.a.b).aB() && LockerService.a().c() && a > 0) {
            ak akVar = new ak();
            akVar.j = "phone";
            akVar.c = this.a.b.getString(R.string.phone);
            akVar.e = this.a.b.getString(R.string.m_p_msg_left) + a + this.a.b.getString(R.string.phone_msg_right);
            akVar.g = new Date().getTime();
            akVar.b = "com.android.phone";
            if (com.vlocker.theme.f.b.k()) {
                akVar.k = z.a(this.a.b.getResources().getDrawable(R.drawable.l_phone_msg));
            } else {
                try {
                    akVar.k = z.a(this.a.b.getPackageManager().getApplicationIcon("com.android.phone"));
                } catch (NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
            p.a().a(akVar);
        }
    }
}
