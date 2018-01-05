package com.vlocker.l;

import android.content.Intent;
import android.content.pm.PackageManager;

class t implements Runnable {
    final /* synthetic */ s a;

    t(s sVar) {
        this.a = sVar;
    }

    public void run() {
        if (this.a.b != null) {
            try {
                PackageManager packageManager = this.a.c.b.getPackageManager();
                Intent intent = new Intent();
                this.a.c.b.startActivity(packageManager.getLaunchIntentForPackage(this.a.b));
                return;
            } catch (Exception e) {
                this.a.c();
                if (this.a.a != null) {
                    this.a.a.a();
                    return;
                }
                return;
            }
        }
        try {
            this.a.c();
            if (this.a.a != null) {
                this.a.a.a();
            }
        } catch (Exception e2) {
        }
    }
}
