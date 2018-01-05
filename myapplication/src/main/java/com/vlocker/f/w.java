package com.vlocker.f;

import android.os.Build;
import android.widget.Toast;
import com.a.a.l;
import com.vlocker.b.j;
import com.vlocker.b.p;

class w implements l {
    final /* synthetic */ t a;

    w(t tVar) {
        this.a = tVar;
    }

    public void a() {
        if (this.a.f != null) {
            this.a.f.a(this.a.g);
        }
        if (this.a.g >= 4) {
            Toast.makeText(this.a.b, "指纹验证失败过多，请稍后再试", 1).show();
            this.a.c();
            p.a(this.a.b, "Vlock_Unlock_FP_PPC_TF", "manufacturer", Build.MANUFACTURER, "status", "false_" + this.a.g);
            return;
        }
        this.a.a.a(this.a.d, this.a.a.c());
        this.a.g = this.a.g + 1;
        p.a(this.a.b, "Vlock_Unlock_FP_PPC_TF", "manufacturer", Build.MANUFACTURER, "status", "false_" + this.a.g);
    }

    public void a(int i, boolean z) {
        if (this.a.f != null) {
            this.a.f.a();
        }
        if ("moxiu-launcher".equals(j.p(this.a.b))) {
            p.a(this.a.b, "Vlocker_Times_Unlock_PPC_TF", new String[0]);
        }
        p.a(this.a.b, "Vlock_Unlock_FP_PPC_TF", "manufacturer", Build.MANUFACTURER, "status", "true");
    }
}
