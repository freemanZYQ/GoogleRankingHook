package com.baidu.location.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.os.Handler;
import com.baidu.location.b.q;
import com.baidu.location.c.h;
import com.baidu.location.f;

public class n {
    private static n b = null;
    final Handler a = new Handler();
    private a c = null;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = true;
    private boolean h = false;

    class a extends BroadcastReceiver {
        final /* synthetic */ n a;

        private a(n nVar) {
            this.a = nVar;
        }

        public void onReceive(Context context, Intent intent) {
            if (context != null && this.a.a != null) {
                this.a.f();
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ n a;

        private b(n nVar) {
            this.a = nVar;
        }

        public void run() {
            if (this.a.g) {
                if (this.a.d && i.a().e() && h.a().d()) {
                    new o(this).start();
                }
                if (this.a.d && i.a().e()) {
                    q.a().d();
                }
                if (this.a.d && this.a.g) {
                    this.a.a.postDelayed(this, (long) com.baidu.location.b.h.N);
                    this.a.f = true;
                    return;
                }
                this.a.f = false;
            }
        }
    }

    private n() {
    }

    public static n a() {
        if (b == null) {
            b = new n();
        }
        return b;
    }

    private void f() {
        State state;
        State state2 = State.UNKNOWN;
        try {
            state = ((ConnectivityManager) f.getServiceContext().getSystemService("connectivity")).getNetworkInfo(1).getState();
        } catch (Exception e) {
            state = state2;
        }
        if (State.CONNECTED != state) {
            this.d = false;
        } else if (!this.d) {
            this.d = true;
            this.a.postDelayed(new b(), (long) com.baidu.location.b.h.N);
            this.f = true;
        }
    }

    public synchronized void b() {
        if (f.isServing) {
            if (!this.h) {
                try {
                    this.c = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    f.getServiceContext().registerReceiver(this.c, intentFilter);
                    this.e = true;
                    f();
                } catch (Exception e) {
                }
                this.g = true;
                this.h = true;
            }
        }
    }

    public synchronized void c() {
        if (this.h) {
            try {
                f.getServiceContext().unregisterReceiver(this.c);
            } catch (Exception e) {
            }
            this.g = false;
            this.h = false;
            this.c = null;
        }
    }

    public void d() {
        if (this.h) {
            this.g = true;
            if (!this.f && this.g) {
                this.a.postDelayed(new b(), (long) com.baidu.location.b.h.N);
                this.f = true;
            }
        }
    }

    public void e() {
        this.g = false;
    }
}
