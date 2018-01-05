package com.vlocker.msg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;

class t extends BroadcastReceiver {
    final /* synthetic */ p a;

    t(p pVar) {
        this.a = pVar;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String stringExtra = intent.getStringExtra("extral_pkg_name");
        intent.getExtras();
        Message obtainMessage;
        if ("com.vlocker.app.msgcount.changed".equals(action)) {
            obtainMessage = this.a.c.obtainMessage();
            obtainMessage.obj = stringExtra;
            obtainMessage.what = 1;
            this.a.c.sendMessage(obtainMessage);
        } else if ("android.intent.action.SCREEN_ON".equals(action)) {
            this.a.c.sendEmptyMessage(2);
        } else if ("com.vlocker.app.msgcount.remove".equals(action)) {
            obtainMessage = this.a.c.obtainMessage();
            obtainMessage.obj = stringExtra;
            obtainMessage.what = 3;
            obtainMessage.arg1 = intent.getIntExtra("id", -1);
            this.a.c.sendMessage(obtainMessage);
        } else if ("com.vlocker.app.msgcount.remove.weahter".equals(action)) {
            obtainMessage = this.a.c.obtainMessage();
            obtainMessage.what = 4;
            this.a.c.sendMessage(obtainMessage);
        } else if ("AlarmChange".equals(action)) {
            as.c(context.getApplicationContext());
            as.b(context.getApplicationContext());
        } else if ("com.vlocker.locker.AlarmSend".equals(action)) {
            as.c(context.getApplicationContext());
            as.e(context.getApplicationContext(), intent.getStringExtra("eventNames"));
        } else if ("action_redpacket_share".equals(action)) {
            McmPushWidget.getInstance(context.getApplicationContext()).sendRedPacketShareMsg();
        } else if ("com.vlocker.open.notification".equals(action)) {
            Message obtainMessage2 = this.a.c.obtainMessage();
            obtainMessage2.what = 6;
            Object c = this.a.c(stringExtra);
            if (c == null) {
                c = new ak();
                c.D = intent.getStringExtra("SpecialMsg");
                c.F = intent.getIntExtra("operation", -1);
                c.p = intent.getIntExtra("id", 113) + "";
                c.c = intent.getStringExtra("title");
                c.b = stringExtra;
                c.q = intent.getStringExtra("bid");
                c.r = intent.getBooleanExtra("isPush", false);
            }
            obtainMessage2.obj = c;
            this.a.c.sendMessage(obtainMessage2);
        }
    }
}
