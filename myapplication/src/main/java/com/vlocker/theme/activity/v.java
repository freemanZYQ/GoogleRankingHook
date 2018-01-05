package com.vlocker.theme.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class v extends BroadcastReceiver {
    final /* synthetic */ UnlockTextEditActivity a;

    private v(UnlockTextEditActivity unlockTextEditActivity) {
        this.a = unlockTextEditActivity;
    }

    public void onReceive(Context context, Intent intent) {
        this.a.finish();
    }
}
