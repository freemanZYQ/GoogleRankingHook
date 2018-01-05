package com.tencent.wxop.stat;

import android.content.Context;
import com.baidu.location.LocationClientOption;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.q;

final class ai {
    private static volatile long f = 0;
    private d a;
    private w b = null;
    private boolean c = false;
    private Context d = null;
    private long e = System.currentTimeMillis();

    public ai(d dVar) {
        this.a = dVar;
        this.b = v.a();
        this.c = dVar.f();
        this.d = dVar.e();
    }

    private void a(k kVar) {
        l.b(x.t).a(this.a, kVar);
    }

    private void b() {
        if (am.b().a <= 0 || !v.m) {
            a(new al(this));
            return;
        }
        am.b().a(this.a, null, this.c, true);
        am.b().a(-1);
    }

    public final void a() {
        boolean z;
        long l;
        if (v.h > 0) {
            if (this.e > x.h) {
                x.g.clear();
                x.h = this.e + v.i;
                if (v.b()) {
                    x.q.a("clear methodsCalledLimitMap, nextLimitCallClearTime=" + x.h);
                }
            }
            Integer valueOf = Integer.valueOf(this.a.b().a());
            Integer num = (Integer) x.g.get(valueOf);
            if (num != null) {
                x.g.put(valueOf, Integer.valueOf(num.intValue() + 1));
                if (num.intValue() > v.h) {
                    if (v.b()) {
                        x.q.e("event " + this.a.g() + " was discard, cause of called limit, current:" + num + ", limit:" + v.h + ", period:" + v.i + " ms");
                    }
                    z = true;
                    if (z) {
                        if (v.n > 0 && this.e >= f) {
                            x.e(this.d);
                            f = this.e + v.o;
                            if (v.b()) {
                                x.q.a("nextFlushTime=" + f);
                            }
                        }
                        if (z.a(this.d).f()) {
                            am.a(this.d).a(this.a, null, this.c, false);
                            return;
                        }
                        if (v.b()) {
                            x.q.a("sendFailedCount=" + x.a);
                        }
                        if (x.a()) {
                            if (this.a.d() != null && this.a.d().a()) {
                                this.b = w.INSTANT;
                            }
                            if (v.j && z.a(x.t).e()) {
                                this.b = w.INSTANT;
                            }
                            if (v.b()) {
                                x.q.a("strategy=" + this.b.name());
                            }
                            switch (ac.a[this.b.ordinal()]) {
                                case 1:
                                    b();
                                    return;
                                case 2:
                                    am.a(this.d).a(this.a, null, this.c, false);
                                    if (v.b()) {
                                        x.q.a("PERIOD currTime=" + this.e + ",nextPeriodSendTs=" + x.c + ",difftime=" + (x.c - this.e));
                                    }
                                    if (x.c == 0) {
                                        x.c = q.a(this.d, "last_period_ts");
                                        if (this.e > x.c) {
                                            x.f(this.d);
                                        }
                                        l = this.e + ((long) ((v.l() * 60) * LocationClientOption.MIN_SCAN_SPAN));
                                        if (x.c > l) {
                                            x.c = l;
                                        }
                                        g.a(this.d).a();
                                    }
                                    if (v.b()) {
                                        x.q.a("PERIOD currTime=" + this.e + ",nextPeriodSendTs=" + x.c + ",difftime=" + (x.c - this.e));
                                    }
                                    if (this.e > x.c) {
                                        x.f(this.d);
                                        return;
                                    }
                                    return;
                                case 3:
                                case 4:
                                    am.a(this.d).a(this.a, null, this.c, false);
                                    return;
                                case 5:
                                    am.a(this.d).a(this.a, new aj(this), this.c, true);
                                    return;
                                case 6:
                                    if (z.a(x.t).c() != 1) {
                                        b();
                                        return;
                                    } else {
                                        am.a(this.d).a(this.a, null, this.c, false);
                                        return;
                                    }
                                case 7:
                                    if (l.e(this.d)) {
                                        a(new ak(this));
                                        return;
                                    }
                                    return;
                                default:
                                    x.q.d("Invalid stat strategy:" + v.a());
                                    return;
                            }
                        }
                        am.a(this.d).a(this.a, null, this.c, false);
                        if (this.e - x.b > 1800000) {
                            x.c(this.d);
                            return;
                        }
                        return;
                    }
                }
            }
            x.g.put(valueOf, Integer.valueOf(1));
        }
        z = false;
        if (z) {
            x.e(this.d);
            f = this.e + v.o;
            if (v.b()) {
                x.q.a("nextFlushTime=" + f);
            }
            if (z.a(this.d).f()) {
                am.a(this.d).a(this.a, null, this.c, false);
                return;
            }
            if (v.b()) {
                x.q.a("sendFailedCount=" + x.a);
            }
            if (x.a()) {
                am.a(this.d).a(this.a, null, this.c, false);
                if (this.e - x.b > 1800000) {
                    x.c(this.d);
                    return;
                }
                return;
            }
            this.b = w.INSTANT;
            this.b = w.INSTANT;
            if (v.b()) {
                x.q.a("strategy=" + this.b.name());
            }
            switch (ac.a[this.b.ordinal()]) {
                case 1:
                    b();
                    return;
                case 2:
                    am.a(this.d).a(this.a, null, this.c, false);
                    if (v.b()) {
                        x.q.a("PERIOD currTime=" + this.e + ",nextPeriodSendTs=" + x.c + ",difftime=" + (x.c - this.e));
                    }
                    if (x.c == 0) {
                        x.c = q.a(this.d, "last_period_ts");
                        if (this.e > x.c) {
                            x.f(this.d);
                        }
                        l = this.e + ((long) ((v.l() * 60) * LocationClientOption.MIN_SCAN_SPAN));
                        if (x.c > l) {
                            x.c = l;
                        }
                        g.a(this.d).a();
                    }
                    if (v.b()) {
                        x.q.a("PERIOD currTime=" + this.e + ",nextPeriodSendTs=" + x.c + ",difftime=" + (x.c - this.e));
                    }
                    if (this.e > x.c) {
                        x.f(this.d);
                        return;
                    }
                    return;
                case 3:
                case 4:
                    am.a(this.d).a(this.a, null, this.c, false);
                    return;
                case 5:
                    am.a(this.d).a(this.a, new aj(this), this.c, true);
                    return;
                case 6:
                    if (z.a(x.t).c() != 1) {
                        am.a(this.d).a(this.a, null, this.c, false);
                        return;
                    } else {
                        b();
                        return;
                    }
                case 7:
                    if (l.e(this.d)) {
                        a(new ak(this));
                        return;
                    }
                    return;
                default:
                    x.q.d("Invalid stat strategy:" + v.a());
                    return;
            }
        }
    }
}
