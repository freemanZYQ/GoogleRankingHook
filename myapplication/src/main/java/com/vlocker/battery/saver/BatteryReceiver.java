package com.vlocker.battery.saver;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BatteryReceiver extends BroadcastReceiver {
    private boolean a;
    private Context b;

    public BatteryReceiver(Context context) {
        this.b = context;
    }

    private PendingIntent a() {
        return PendingIntent.getBroadcast(this.b, 0, new Intent("battery_action_full_send"), 134217728);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r10, android.content.Intent r11) {
        /*
        r9 = this;
        r8 = 5;
        r7 = 2;
        r6 = -1;
        r2 = 1;
        r1 = 0;
        r0 = "android.intent.action.BATTERY_CHANGED";
        r3 = r11.getAction();
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0085;
    L_0x0012:
        r0 = "level";
        r3 = r11.getIntExtra(r0, r1);
        r0 = "scale";
        r4 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r4 = r11.getIntExtra(r0, r4);
        r0 = "status";
        r5 = r11.getIntExtra(r0, r6);
        if (r5 == r7) goto L_0x002d;
    L_0x002b:
        if (r5 != r8) goto L_0x015f;
    L_0x002d:
        r0 = r2;
    L_0x002e:
        r3 = r3 * 100;
        r3 = r3 / r4;
        com.vlocker.battery.saver.a.a = r3;
        r3 = "plugged";
        r3 = r11.getIntExtra(r3, r6);
        com.vlocker.battery.saver.a.c = r3;
        r3 = "temperature";
        r3 = r11.getIntExtra(r3, r6);
        r3 = r3 / 10;
        com.vlocker.battery.saver.a.d = r3;
        if (r5 != r7) goto L_0x0162;
    L_0x0049:
        com.vlocker.battery.saver.a.b = r2;
    L_0x004b:
        r3 = com.vlocker.battery.saver.a.b;
        if (r3 == 0) goto L_0x005b;
    L_0x004f:
        r3 = "plugged";
        r3 = r11.getIntExtra(r3, r6);
        r4 = com.vlocker.battery.saver.a.a;
        com.vlocker.m.e.a(r0, r3, r4);
    L_0x005b:
        r0 = com.vlocker.battery.saver.a.a;
        r3 = 100;
        if (r0 != r3) goto L_0x0085;
    L_0x0061:
        r0 = com.vlocker.battery.saver.a.b;
        if (r0 == 0) goto L_0x0085;
    L_0x0065:
        r0 = r9.a;
        if (r0 != 0) goto L_0x0085;
    L_0x0069:
        r9.a = r2;
        r0 = r9.b;
        r3 = "alarm";
        r0 = r0.getSystemService(r3);
        r0 = (android.app.AlarmManager) r0;
        r4 = java.lang.System.currentTimeMillis();
        r6 = 1800000; // 0x1b7740 float:2.522337E-39 double:8.89318E-318;
        r4 = r4 + r6;
        r3 = r9.a();
        r0.set(r1, r4, r3);
    L_0x0085:
        r0 = "android.intent.action.ACTION_POWER_DISCONNECTED";
        r3 = r11.getAction();
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x00fe;
    L_0x0092:
        r0 = com.vlocker.battery.saver.b.a(r10);
        r0.b(r1);
        com.vlocker.battery.saver.a.b = r1;
        r0 = com.vlocker.battery.saver.a.c;
        com.vlocker.m.e.a(r0);
        com.vlocker.m.e.a();
        r0 = com.vlocker.security.MoSecurityApplication.a();
        r0 = com.vlocker.battery.saver.b.a(r0);
        r0.c();
        r0 = r9.a;
        if (r0 == 0) goto L_0x00c6;
    L_0x00b2:
        r9.a = r1;
        r0 = r9.b;
        r3 = "alarm";
        r0 = r0.getSystemService(r3);
        r0 = (android.app.AlarmManager) r0;
        r3 = r9.a();
        r0.cancel(r3);
    L_0x00c6:
        r0 = r9.b;
        r3 = new android.content.Intent;
        r4 = "battery_action_full_cancel";
        r3.<init>(r4);
        r0.sendBroadcast(r3);
        r0 = com.vlocker.battery.clean.y.a();
        r0.c();
        r0 = com.vlocker.battery.clean.y.a();
        r0 = r0.f();
        if (r0 == 0) goto L_0x00fe;
    L_0x00e4:
        r0 = com.vlocker.msg.p.a();
        r3 = 10;
        r0 = r0.a(r3);
        if (r0 != 0) goto L_0x00fe;
    L_0x00f0:
        r0 = com.vlocker.battery.clean.y.a();
        r0.a(r2);
        r0 = com.vlocker.battery.clean.y.a();
        r0.b(r2);
    L_0x00fe:
        r0 = "android.intent.action.ACTION_POWER_CONNECTED";
        r3 = r11.getAction();
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x012f;
    L_0x010b:
        r0 = com.vlocker.battery.saver.b.a(r10);
        r0.b(r1);
        r0 = "moxiu-launcher";
        r3 = r9.b;
        r3 = com.vlocker.b.j.p(r3);
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0129;
    L_0x0121:
        r0 = "Vlocker_TurnTo_Charge_Battery_PPC_TF";
        r3 = new java.lang.String[r1];
        com.vlocker.b.p.a(r10, r0, r3);
    L_0x0129:
        com.vlocker.battery.saver.a.b = r2;
        r0 = com.vlocker.battery.saver.a.b;
        if (r0 == 0) goto L_0x012f;
    L_0x012f:
        r0 = "android.intent.action.HEADSET_PLUG";
        r3 = r11.getAction();
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x015e;
    L_0x013c:
        r0 = "moxiu-launcher";
        r3 = r9.b;
        r3 = com.vlocker.b.j.p(r3);
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x015e;
    L_0x014b:
        if (r11 == 0) goto L_0x015e;
    L_0x014d:
        r0 = "state";
        r0 = r11.getIntExtra(r0, r1);
        if (r0 != r2) goto L_0x015e;
    L_0x0156:
        r0 = "Vlocker_Insert_Earphone_PPC_TF";
        r1 = new java.lang.String[r1];
        com.vlocker.b.p.a(r10, r0, r1);
    L_0x015e:
        return;
    L_0x015f:
        r0 = r1;
        goto L_0x002e;
    L_0x0162:
        if (r5 == r8) goto L_0x004b;
    L_0x0164:
        com.vlocker.battery.saver.a.b = r1;
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vlocker.battery.saver.BatteryReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
