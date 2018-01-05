package com.vlocker.settings;

import android.content.Context;
import android.content.Intent;

final class aj implements Runnable {
    final /* synthetic */ Context a;

    aj(Context context) {
        this.a = context;
    }

    public void run() {
        try {
            Intent intent = new Intent(this.a, GuideSettingListActivity.class);
            intent.setFlags(268435456);
            this.a.startActivity(intent);
        } catch (Exception e) {
        }
    }
}
