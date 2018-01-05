package com.vlocker.m;

import android.content.Context;
import android.provider.Settings.System;
import com.vlocker.c.a;
import com.vlocker.security.MoSecurityApplication;

final class am extends Thread {
    final /* synthetic */ boolean a;

    am(boolean z) {
        this.a = z;
    }

    public void run() {
        try {
            Context a = MoSecurityApplication.a();
            a a2 = a.a(a);
            if (!a2.de()) {
                return;
            }
            if (!a2.bH() || this.a) {
                if (!a2.bH()) {
                    al.b();
                }
                a2.ai(true);
                System.putInt(a.getContentResolver(), "screen_off_timeout", al.a);
            }
        } catch (Exception e) {
        }
    }
}
