package com.vlocker.security;

import android.os.Build.VERSION;
import com.vlocker.theme.f.b;
import com.vlocker.ui.cover.LockerService;

class c implements Runnable {
    final /* synthetic */ MoSecurityApplication a;

    c(MoSecurityApplication moSecurityApplication) {
        this.a = moSecurityApplication;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        if (!b.p() || VERSION.SDK_INT <= 18) {
            LockerService.a(this.a);
            return;
        }
        try {
            LockerService.a(this.a);
        } catch (Exception e2) {
        }
    }
}
