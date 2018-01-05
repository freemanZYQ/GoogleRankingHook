package com.vlocker.m;

import com.baidu.location.LocationClientOption;
import com.vlocker.locker.BuildConfig;

class j extends Thread {
    String a;
    final /* synthetic */ i b;

    public j(i iVar, String str) {
        this.b = iVar;
        this.a = str;
    }

    public void run() {
        synchronized (i.a) {
            StringBuffer stringBuffer = new StringBuffer();
            int g = i.h();
            if (g < LocationClientOption.MIN_SCAN_SPAN) {
                return;
            }
            i.b(BuildConfig.APPLICATION_ID, this.a + g, stringBuffer);
        }
    }
}
