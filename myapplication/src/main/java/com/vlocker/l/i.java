package com.vlocker.l;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.text.TextUtils;
import com.vlocker.ui.cover.LockerService;
import java.util.List;

class i implements Runnable {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public void run() {
        ActivityManager activityManager = (ActivityManager) this.a.b.getApplicationContext().getSystemService("activity");
        int b = this.a.b();
        String str = null;
        String str2 = null;
        Object obj = null;
        long j = 0;
        Object obj2 = null;
        while (true) {
            String packageName;
            Object obj3;
            String str3;
            Object obj4;
            long j2;
            List runningTasks = activityManager.getRunningTasks(1);
            if (runningTasks != null && runningTasks.size() > 0) {
                RunningTaskInfo runningTaskInfo = (RunningTaskInfo) runningTasks.get(0);
                if (runningTaskInfo.topActivity != null) {
                    packageName = runningTaskInfo.topActivity.getPackageName();
                    if ("com.android.settings".equalsIgnoreCase(packageName) && str == null) {
                        obj3 = 1;
                        str3 = packageName;
                    } else {
                        obj3 = obj;
                        str3 = str;
                    }
                    if (str3 == null || !str3.equalsIgnoreCase("com.android.settings")) {
                        packageName = str3;
                        str3 = str2;
                    } else {
                        String str4 = packageName;
                        packageName = str3;
                        str3 = str4;
                    }
                    obj4 = (TextUtils.isEmpty(packageName) || packageName.equalsIgnoreCase(str3)) ? b == this.a.b() ? 1 : obj2 : 1;
                    if (obj4 != null || packageName == null) {
                        Thread.sleep(500);
                        j2 = obj3 == null ? j + 500 : j;
                        if (obj3 != null || j2 <= 60000) {
                            str = packageName;
                            j = j2;
                            obj2 = obj4;
                            str2 = str3;
                            obj = obj3;
                        } else {
                            return;
                        }
                    }
                    LockerService.b(this.a.b.getApplicationContext());
                    return;
                }
            }
            obj3 = obj;
            packageName = str;
            str3 = str2;
            if (!TextUtils.isEmpty(packageName)) {
            }
            if (b == this.a.b()) {
            }
            if (obj4 != null) {
            }
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (obj3 == null) {
            }
            if (obj3 != null) {
            }
            str = packageName;
            j = j2;
            obj2 = obj4;
            str2 = str3;
            obj = obj3;
        }
    }
}
