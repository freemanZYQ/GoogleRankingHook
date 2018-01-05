package com.vlocker.m;

import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import com.vlocker.c.a;
import com.vlocker.security.MoSecurityApplication;

public class al {
    private static int a = 15000;
    private static int b = 15000;

    public static void a() {
        Context a = MoSecurityApplication.a();
        a a2 = a.a(a);
        if (a2.aT() == 0) {
            try {
                a2.r(System.getInt(a.getContentResolver(), "screen_off_timeout"));
            } catch (SettingNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e2) {
            }
        } else if (!a2.bH()) {
            b();
        }
    }

    public static void a(boolean z) {
        new am(z).start();
    }

    public static void b() {
        try {
            Context a = MoSecurityApplication.a();
            a a2 = a.a(a);
            int i = System.getInt(a.getContentResolver(), "screen_off_timeout");
            if (i != a2.aT() && i >= b) {
                a2.r(i);
            }
        } catch (SettingNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e2) {
        }
    }

    public static void c() {
        new an().start();
    }
}
