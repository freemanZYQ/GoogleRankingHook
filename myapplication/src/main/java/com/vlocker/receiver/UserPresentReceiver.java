package com.vlocker.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.vlocker.c.a;
import com.vlocker.f.j;
import com.vlocker.ui.cover.LockerService;
import com.vlocker.ui.cover.g;
import com.vlocker.ui.cover.k;

public class UserPresentReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (!a.a(context).O()) {
            return;
        }
        if (intent == null || !intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            if (intent != null && intent.getAction().equals("android.intent.action.ACTION_SHUTDOWN")) {
                a.a(context).aS(true);
            }
            if (intent != null && intent.getAction().equals("android.intent.action.USER_PRESENT")) {
                if (!k.a(context)) {
                    k.b(context, false);
                    k.a(context, false);
                }
                if (g.a && a.a(context).cg() && j.a() != null && LockerService.e(context) && LockerService.a().d() != null) {
                    j.a().c();
                    j.a().a(LockerService.a().d());
                }
            }
            LockerService.a(context);
            return;
        }
        LockerService.c(context);
    }
}
