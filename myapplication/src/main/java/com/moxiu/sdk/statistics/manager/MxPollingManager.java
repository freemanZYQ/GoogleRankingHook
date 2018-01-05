package com.moxiu.sdk.statistics.manager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import com.moxiu.sdk.statistics.e.e;
import com.moxiu.sdk.statistics.e.i;
import com.moxiu.sdk.statistics.e.k;

public class MxPollingManager {
    private static MxPollingManager h = null;
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private StatPollingReceiver e;
    private PendingIntent f;
    private Context g;

    public class StatPollingReceiver extends BroadcastReceiver {
        final /* synthetic */ MxPollingManager a;

        public StatPollingReceiver(MxPollingManager mxPollingManager) {
            this.a = mxPollingManager;
        }

        public void onReceive(Context context, Intent intent) {
            i.a("onReceive");
            this.a.f();
        }
    }

    private MxPollingManager() {
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = null;
        this.f = null;
        this.g = null;
        this.g = h.a().b();
        this.e = new StatPollingReceiver(this);
        Intent intent = new Intent(this.g, MxIntentService.class);
        intent.setAction("pollingcheck");
        this.f = PendingIntent.getService(this.g, 0, intent, 0);
    }

    public static MxPollingManager a() {
        if (h == null) {
            synchronized (e.class) {
                if (h == null) {
                    h = new MxPollingManager();
                }
            }
        }
        return h;
    }

    private void g() {
        i.a("startCheck");
        if (this.c || this.d) {
            if (!this.a) {
                i();
            }
            if (!this.b) {
                k();
            }
        }
    }

    private void h() {
        i.a("stopCheck");
        if (!this.c && !this.d) {
            if (this.a) {
                j();
            }
            if (this.b) {
                l();
            }
        }
    }

    private void i() {
        i.a("registerReceiver");
        this.g.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.a = true;
    }

    private void j() {
        i.a("unRegisterReceiver");
        this.g.unregisterReceiver(this.e);
        this.a = false;
    }

    private void k() {
        i.a("registerAlarm");
        ((AlarmManager) this.g.getSystemService("alarm")).setRepeating(2, SystemClock.elapsedRealtime() + 3600000, 3600000, this.f);
        this.b = true;
    }

    private void l() {
        i.a("unRegisterAlarm");
        ((AlarmManager) this.g.getSystemService("alarm")).cancel(this.f);
        this.b = false;
    }

    public void b() {
        i.a("checkCache");
        if (!this.c) {
            this.c = true;
            g();
        }
    }

    public void c() {
        i.a("checkDelay");
        if (!this.d) {
            this.d = true;
            g();
        }
    }

    public void d() {
        i.a("unCheckCache");
        this.c = false;
        h();
    }

    public void e() {
        i.a("unCheckDelay");
        this.d = false;
        h();
    }

    public void f() {
        i.a("checkAndPost");
        if (k.a(this.g) == e.noNetStatus) {
            i.a("no net return");
            return;
        }
        if (this.c) {
            a.a().b();
        }
        if (this.d) {
            e.a().b();
        }
    }
}
