package com.vlocker.ui.cover;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.location.LocationClientOption;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.battery.saver.a;
import com.vlocker.battery.saver.b;
import com.vlocker.locker.b.ap;
import com.vlocker.m.h;
import com.vlocker.m.i;
import com.vlocker.security.MoSecurityApplication;
import com.vlocker.update.UpdateApkParamBean;
import com.vlocker.weather.b.c;

class y extends BroadcastReceiver {
    final /* synthetic */ LockerService a;

    y(LockerService lockerService) {
        this.a = lockerService;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.a.i.O()) {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action) || LockerService.c.equals(action)) {
                p.b();
                i.a().d();
                if (this.a.e == 0) {
                    this.a.e = System.currentTimeMillis();
                }
                if (this.a.i.an() == 0) {
                    if (this.a.l == null || !this.a.l.b()) {
                        this.a.o();
                    } else {
                        return;
                    }
                }
                if (a.b && this.a.i.bX() && System.currentTimeMillis() > this.a.i.bZ()) {
                    b.a(MoSecurityApplication.a()).a();
                }
                com.vlocker.msg.a.a.a(context).a();
            } else if ("android.intent.action.SCREEN_ON".equals(action) || LockerService.b.equals(action)) {
                if ("moxiu-launcher".equals(j.p(context))) {
                    if (a.b) {
                        if (LockerService.f) {
                            p.a(context, "Vlocker_PowerON_Charge_Battery_PPC_TF", "status", "Manual");
                        } else {
                            p.a(context, "Vlocker_PowerON_Charge_Battery_PPC_TF", "status", "Auto");
                            LockerService.f = true;
                        }
                    }
                    this.a.v();
                }
                if (this.a.u.v()) {
                    com.vlocker.msg.p.a().m();
                }
                if (this.a.i.an() == 0) {
                    this.a.n();
                } else if (!h.a(context, this.a.e)) {
                    this.a.e = 0;
                    this.a.o();
                    this.a.n();
                }
                i.a().e();
            } else if (LockerService.a.equals(intent.getAction())) {
                ap.a(context).a(intent.getExtras());
            } else if ("com.vlocker.ACTION_WALLPAPER_UI_UPDATE".equals(intent.getAction())) {
                if (this.a.u != null) {
                    this.a.u.s();
                }
            } else if ("com.vlocker.service.ACTION_WEATHER_UPDATE".equals(intent.getAction())) {
                if (this.a.u != null) {
                    this.a.u.a(intent);
                }
            } else if ("com.vlocker.service.ACTION_LOCATION_UPDATE".equals(intent.getAction())) {
                c.a(this.a.getApplicationContext()).a(true);
            } else if ("com.vlocker.locker.update.receiver".equals(intent.getAction())) {
                Bundle extras = intent.getExtras();
                int i = extras.getInt("fromtag");
                com.vlocker.e.a aVar;
                if (i == 1) {
                    aVar = new com.vlocker.e.a(context, (UpdateApkParamBean) extras.getParcelable("updatebean"), LocationClientOption.MIN_SCAN_SPAN);
                } else if (i == 3) {
                    aVar = new com.vlocker.e.a(context, (UpdateApkParamBean) extras.getParcelable("updatebean"), 0);
                }
            } else if ("android.intent.action.DATE_CHANGED".equals(intent.getAction())) {
                com.vlocker.c.a.a(context).a("");
                com.vlocker.c.a.a(context).b("");
            } else if (LockerService.g.equals(intent.getAction())) {
                this.a.a(null, 2);
            }
        }
    }
}
