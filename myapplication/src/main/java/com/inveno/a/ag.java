package com.inveno.a;

import a.e;
import a.f;
import java.io.File;
import java.io.IOException;

public class ag {
    private static ag b;
    private long a;

    private ag() {
        if (m.c) {
            try {
                this.a = Long.valueOf(e.a(e.a(i.a, "reportdata" + File.separator + "expireTime"))).longValue();
                return;
            } catch (NumberFormatException e) {
                this.a = 0;
                e.printStackTrace();
                return;
            }
        }
        this.a = f.b(i.a, "config", "expire_time");
    }

    public static synchronized ag a() {
        ag agVar;
        synchronized (ag.class) {
            if (b == null) {
                b = new ag();
            }
            agVar = b;
        }
        return agVar;
    }

    public void a(long j) {
        this.a = System.currentTimeMillis() + (1000 * j);
        f.a(i.a, "config", "expire_time", this.a);
        if (m.c) {
            try {
                e.a(String.valueOf(this.a), e.a(i.a, "reportdata" + File.separator + "expireTime"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean b() {
        return System.currentTimeMillis() > this.a;
    }
}
