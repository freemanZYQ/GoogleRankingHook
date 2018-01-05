package com.vlocker.l;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.List;

class x implements Runnable {
    final /* synthetic */ j a;
    final /* synthetic */ w b;

    x(w wVar, j jVar) {
        this.b = wVar;
        this.a = jVar;
    }

    public void run() {
        try {
            Object obj;
            PackageManager packageManager = this.b.c.b.getPackageManager();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            for (PackageInfo packageInfo : installedPackages) {
                if (this.b.a(packageInfo.packageName.toString().toLowerCase())) {
                    this.b.d = packageManager.getLaunchIntentForPackage(packageInfo.packageName);
                    if (this.b.d != null) {
                        this.b.d.addFlags(268435456);
                        this.b.b = new aj(this.b.c.b, packageInfo.packageName);
                        obj = 1;
                        break;
                    }
                }
            }
            obj = null;
            if (obj == null) {
                for (PackageInfo packageInfo2 : installedPackages) {
                    if (packageInfo2.packageName.toString().toLowerCase().contains("calculator")) {
                        this.b.d = packageManager.getLaunchIntentForPackage(packageInfo2.packageName);
                        if (this.b.d != null) {
                            this.b.d.addFlags(268435456);
                            this.b.b = new aj(this.b.c.b, packageInfo2.packageName);
                            return;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
    }
}
