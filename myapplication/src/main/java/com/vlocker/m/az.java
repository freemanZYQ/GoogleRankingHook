package com.vlocker.m;

import android.widget.Toast;
import com.vlocker.security.MoSecurityApplication;

public class az {
    private static Toast a;

    public static void a(String str) {
        if (a != null) {
            a.cancel();
            a = Toast.makeText(MoSecurityApplication.a(), str, 0);
        } else {
            a = Toast.makeText(MoSecurityApplication.a(), str, 0);
        }
        a.show();
    }
}
