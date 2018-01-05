package com.vlocker.ui.cover;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.pass.SpassFingerprint;
import com.vlocker.f.a.a;
import com.vlocker.f.i;

class ae extends BroadcastReceiver {
    final /* synthetic */ LockerService a;

    ae(LockerService lockerService) {
        this.a = lockerService;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!SpassFingerprint.ACTION_FINGERPRINT_RESET.equals(action) && !SpassFingerprint.ACTION_FINGERPRINT_REMOVED.equals(action) && SpassFingerprint.ACTION_FINGERPRINT_ADDED.equals(action) && k.a(context)) {
            try {
                if (i.b) {
                    a.a(context);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
