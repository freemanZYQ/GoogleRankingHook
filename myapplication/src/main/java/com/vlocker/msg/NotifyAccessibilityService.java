package com.vlocker.msg;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.accessibility.AccessibilityEvent;
import com.vlocker.c.a;
import com.vlocker.ui.cover.LockerService;

@TargetApi(14)
public class NotifyAccessibilityService extends AccessibilityService {
    private final AccessibilityServiceInfo a = new AccessibilityServiceInfo();

    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
    }

    public void onCreate() {
        try {
            if (SystemClock.elapsedRealtime() < 240000 && a.a((Context) this).O()) {
                LockerService.c((Context) this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onCreate();
    }

    public void onDestroy() {
        an.a(false);
        super.onDestroy();
    }

    public void onInterrupt() {
    }

    public void onServiceConnected() {
        this.a.eventTypes = 64;
        if (VERSION.SDK_INT >= 14) {
            this.a.feedbackType = -1;
        } else {
            this.a.feedbackType = 16;
        }
        this.a.notificationTimeout = 100;
        setServiceInfo(this.a);
    }
}
