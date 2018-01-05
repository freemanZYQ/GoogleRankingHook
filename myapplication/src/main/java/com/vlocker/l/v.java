package com.vlocker.l;

import android.content.Intent;
import com.vlocker.settings.SettingsActivity;

class v implements Runnable {
    final /* synthetic */ u a;

    v(u uVar) {
        this.a = uVar;
    }

    public void run() {
        try {
            Intent intent = new Intent(this.a.a.b, SettingsActivity.class);
            intent.setFlags(268435456);
            this.a.a.b.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
