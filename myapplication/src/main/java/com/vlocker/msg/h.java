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

class h extends ContentObserver {
    final /* synthetic */ f a;

    public h(f fVar, Handler handler) {
        this.a = fVar;
        super(handler);
    }

    public void onChange(boolean z) {
        int b = b.b(this.a.b);
        if (a.a(this.a.b).aB() && LockerService.a().c() && b > 0) {
            ak akVar = new ak();
            akVar.c = this.a.b.getString(R.string.msm);
            akVar.e = this.a.b.getString(R.string.m_p_msg_left) + b + this.a.b.getString(R.string.msm_msg_right);
            akVar.j = "msm";
            akVar.g = new Date().getTime();
            akVar.b = "com.android.mms";
            if (com.vlocker.theme.f.b.k()) {
                akVar.k = z.a(this.a.b.getResources().getDrawable(R.drawable.l_msm_msg));
            } else {
                try {
                    akVar.k = z.a(this.a.b.getPackageManager().getApplicationIcon("com.android.mms"));
                } catch (NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
            p.a().a(akVar);
            if (a.a(this.a.b).aS()) {
                try {
                    this.a.c.postDelayed(new i(this), 1000);
                } catch (Exception e2) {
                }
            }
        }
    }
}
