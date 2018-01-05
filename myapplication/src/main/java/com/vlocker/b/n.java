package com.vlocker.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import com.vlocker.c.a;
import com.vlocker.k.d;
import com.vlocker.msg.McmPushWidget;
import com.vlocker.security.MoSecurityApplication;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

final class n implements Runnable {
    n() {
    }

    public void run() {
        a a = a.a(MoSecurityApplication.a());
        int parseInt = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        if (parseInt > a.bO()) {
            d.a(MoSecurityApplication.a()).a();
            a.am(false);
            a.J(parseInt);
        }
        if (a.bK() && !a.bP() && d.a(MoSecurityApplication.a()).a(0) >= 10 && Calendar.getInstance().get(10) < 11) {
            a.am(true);
            if (Calendar.getInstance().get(10) >= 9) {
                McmPushWidget.getInstance(MoSecurityApplication.a()).sendRedPacketShareMsg();
                return;
            }
            Calendar instance = Calendar.getInstance();
            Calendar.getInstance();
            parseInt = instance.get(1);
            Calendar.getInstance();
            int i = instance.get(2);
            Calendar.getInstance();
            instance.set(parseInt, i, instance.get(5), 9, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            ((AlarmManager) MoSecurityApplication.a().getSystemService("alarm")).set(0, instance.getTimeInMillis(), PendingIntent.getBroadcast(MoSecurityApplication.a(), 0, new Intent("action_redpacket_share"), 134217728));
        }
    }
}
