package com.vlocker.msg;

import android.app.Notification;
import android.text.format.Time;
import com.vlocker.c.a;
import java.util.Date;

class ai implements Runnable {
    final /* synthetic */ Notification a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ long d;
    final /* synthetic */ ab e;

    ai(ab abVar, Notification notification, String str, String str2, long j) {
        this.e = abVar;
        this.a = notification;
        this.b = str;
        this.c = str2;
        this.d = j;
    }

    public void run() {
        try {
            ak a = this.e.a(this.a, this.b, this.c);
            if (a != null && a.a()) {
                synchronized (this.e.o) {
                    a.h = this.a.contentIntent;
                    if (this.e.o.containsKey(a.b)) {
                        ak akVar = (ak) this.e.o.get(a.b);
                        if (akVar.I >= this.d) {
                            return;
                        }
                        a.I = this.d;
                        a.a = akVar.a + 1;
                        this.e.o.put(this.b, a);
                    } else {
                        a.a = 1;
                        a.I = this.d;
                        if ((a.b.equals("com.android.mms") || a.b.equals("com.android.contacts") || a.b.equals("com.tencent.qrom.mms") || a.b.equals("com.htc.sense.mms")) && a.e != null && a.e.length() <= 10 && (!(a.e.contains("新") || a.e.contains("未读")) || a.e.contains("信息") || a.e.contains("消息 ") || !a.e.contains("短信"))) {
                            this.e.o.put(this.b, a);
                        } else {
                            this.e.o.put(this.b, a);
                        }
                    }
                    if (a.a(this.e.m).aS() && a.a(this.e.m).s(a.b)) {
                        long time = new Date().getTime();
                        if (time < this.e.u) {
                            this.e.u = 0;
                        }
                        if (time - this.e.u > 10100) {
                            Time time2 = new Time();
                            time2.setToNow();
                            if (this.e.a(time2) && this.e.a(time)) {
                                this.e.f();
                                this.e.u = time;
                            }
                        }
                    }
                    this.e.f(this.b);
                }
            }
        } catch (Exception e) {
        }
    }
}
