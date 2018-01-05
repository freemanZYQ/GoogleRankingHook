package com.vlocker.setting.common.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

class g extends BroadcastReceiver {
    final String a = "reason";
    final String b = "globalactions";
    final String c = "recentapps";
    final String d = "homekey";
    final /* synthetic */ e e;

    g(e eVar) {
        this.e = eVar;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
            String stringExtra = intent.getStringExtra("reason");
            if (stringExtra != null) {
                if (this.e.b != null) {
                    if (stringExtra.equals("homekey")) {
                        ((f) this.e.b).e();
                    } else if (stringExtra.equals("recentapps")) {
                        ((f) this.e.b).f();
                    }
                }
                Log.e(getClass().getSimpleName(), "action:" + action + ",reason:" + stringExtra);
            }
        }
    }
}
