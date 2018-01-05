package com.vlocker.settings;

import android.content.Context;
import android.util.Log;

class cl extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ SettingsActivity b;

    cl(SettingsActivity settingsActivity, Context context) {
        this.b = settingsActivity;
        this.a = context;
    }

    public void run() {
        Log.e("splash", "start splash");
        this.b.e(this.a);
    }
}
