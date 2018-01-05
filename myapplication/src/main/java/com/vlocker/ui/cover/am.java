package com.vlocker.ui.cover;

import android.content.Context;
import android.content.IntentFilter;
import android.telephony.TelephonyManager;
import com.vlocker.receiver.PhoneStateReceiver;

public class am {
    static boolean b = false;
    Context a;
    private ap c;
    private PhoneStateReceiver d = null;
    private boolean e = false;

    public am(Context context) {
        this.a = context;
    }

    public static boolean a(Context context) {
        return b ? true : ((TelephonyManager) context.getSystemService("phone")).getCallState() != 0;
    }

    private void d() {
        new Thread(new an(this)).start();
    }

    private void e() {
        if (this.d == null) {
            this.d = new PhoneStateReceiver();
            this.d.a(new ao(this));
            this.a.registerReceiver(this.d, new IntentFilter("android.intent.action.PHONE_STATE"));
        }
    }

    private void f() {
        if (this.d != null) {
            this.a.unregisterReceiver(this.d);
            this.d = null;
        }
    }

    public void a() {
        e();
    }

    public void a(ap apVar) {
        this.c = apVar;
    }

    public void b() {
        f();
    }

    public void c() {
        if (a(this.a.getApplicationContext())) {
            if (g.a) {
                this.c.a(10);
                this.e = true;
            }
            d();
        } else if (this.e) {
            this.e = false;
            this.c.b(10);
        }
    }
}
