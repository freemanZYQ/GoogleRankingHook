package com.vlocker.m;

import android.content.Context;
import android.provider.Settings.System;
import com.vlocker.c.a;
import com.vlocker.security.MoSecurityApplication;

final class an extends Thread {
    an() {
    }

    public void run() {
        try {
            Context a = MoSecurityApplication.a();
            a a2 = a.a(a);
            if (a2.aT() != 0 && a2.bH()) {
                System.putInt(a.getContentResolver(), "screen_off_timeout", a2.aT());
                a2.ai(false);
            }
        } catch (Exception e) {
        }
    }
}
