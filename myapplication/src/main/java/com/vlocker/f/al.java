package com.vlocker.f;

import android.os.Build;
import android.widget.Toast;
import com.samsung.android.sdk.pass.SpassFingerprint;
import com.samsung.android.sdk.pass.SpassFingerprint.IdentifyListener;
import com.vlocker.b.j;
import com.vlocker.b.p;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class al implements IdentifyListener {
    final /* synthetic */ ai a;

    al(ai aiVar) {
        this.a = aiVar;
    }

    public void onCompleted() {
    }

    public void onFinished(int i) {
        switch (i) {
            case 0:
                if (this.a.h != null) {
                    this.a.h.a();
                }
                if ("moxiu-launcher".equals(j.p(this.a.c))) {
                    p.a(this.a.c, "Vlocker_Times_Unlock_PPC_TF", new String[0]);
                }
                p.a(this.a.c, "Vlock_Unlock_FP_PPC_TF", "manufacturer", Build.MANUFACTURER, "status", "true");
                return;
            case 12:
                try {
                    Toast.makeText(this.a.c, this.a.d.getGuideForPoorQuality(), 0).show();
                    Executors.newSingleThreadScheduledExecutor().schedule(new an(this), 2, TimeUnit.SECONDS);
                    return;
                } catch (Exception e) {
                    return;
                }
            case 16:
                if (this.a.h != null) {
                    this.a.h.a(this.a.a);
                }
                ai aiVar = this.a;
                aiVar.a++;
                p.a(this.a.c, "Vlock_Unlock_FP_PPC_TF", "manufacturer", Build.MANUFACTURER, "status", "false_" + this.a.a);
                try {
                    if (this.a.a == 5) {
                        Toast.makeText(this.a.c, "指纹验证失败过多，请稍后再试", 1).show();
                        this.a.d.startIdentifyWithDialog(this.a.c, this.a.f, true);
                        return;
                    }
                    Executors.newSingleThreadScheduledExecutor().schedule(new am(this), 2, TimeUnit.SECONDS);
                    return;
                } catch (Exception e2) {
                    return;
                }
            case SpassFingerprint.STATUS_AUTHENTIFICATION_PASSWORD_SUCCESS /*100*/:
                if (this.a.h != null) {
                    this.a.h.a();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onReady() {
    }

    public void onStarted() {
    }
}
