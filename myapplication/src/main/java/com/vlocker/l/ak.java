package com.vlocker.l;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import java.util.List;

class ak implements Runnable {
    final /* synthetic */ aj a;

    ak(aj ajVar) {
        this.a = ajVar;
    }

    public void run() {
        List runningTasks = ((ActivityManager) this.a.c.getSystemService("activity")).getRunningTasks(1);
        int i = (runningTasks == null || runningTasks.size() <= 0 || ((RunningTaskInfo) runningTasks.get(0)).baseActivity == null || !((RunningTaskInfo) runningTasks.get(0)).baseActivity.getPackageName().equals(this.a.b)) ? 0 : 1;
        if (i != 0) {
            this.a.a.postDelayed(this.a.e, 200);
        } else {
            this.a.d.reenableKeyguard();
        }
    }
}
