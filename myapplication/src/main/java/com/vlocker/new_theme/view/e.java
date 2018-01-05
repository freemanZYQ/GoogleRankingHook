package com.vlocker.new_theme.view;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.os.Handler;
import android.os.Message;

class e extends Handler {
    final /* synthetic */ TabFragmentIndicator a;

    e(TabFragmentIndicator tabFragmentIndicator) {
        this.a = tabFragmentIndicator;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                if (System.currentTimeMillis() - this.a.p.longValue() > 3000) {
                    try {
                        if (!((RunningTaskInfo) ((ActivityManager) this.a.b.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName().contains("activity.MainActivity")) {
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }
}
