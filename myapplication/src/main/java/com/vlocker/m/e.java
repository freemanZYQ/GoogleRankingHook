package com.vlocker.m;

import android.os.SystemClock;
import com.vlocker.battery.saver.a;
import com.vlocker.security.MoSecurityApplication;
import java.util.Vector;

public class e {
    static Vector a = new Vector();
    static long b;
    static int c;

    private static int a(int i, long j, int i2, long j2) {
        if (j < 0 || i2 <= 0) {
            return i;
        }
        long j3 = j2 - j;
        for (int i3 = 0; i3 < i2; i3++) {
            long j4 = j3 / ((long) (i2 - i3));
            j3 -= j4;
            a.add(Long.valueOf(j4));
        }
        i += i2;
        return i > a.size() ? a.size() : i;
    }

    public static long a(int i, int i2) {
        if (a != null && a.size() >= 2) {
            a(a.c);
            a();
        }
        long K = com.vlocker.c.a.a(MoSecurityApplication.a()).K(i);
        return K <= 0 ? -1 : K * ((long) (100 - i2));
    }

    public static void a() {
        b = 0;
        c = 0;
        if (a != null && a.size() > 0) {
            a.clear();
        }
    }

    public static void a(int i) {
        long b = b();
        if (b > 0) {
            com.vlocker.c.a a = com.vlocker.c.a.a(MoSecurityApplication.a());
            if (a.size() >= 2) {
                long K = a.K(i);
                long N = a.N(i);
                b = ((b * ((long) a.size())) + (K * N)) / (((long) a.size()) + N);
                a.b(i, ((long) a.size()) + N);
                a.a(i, b);
            }
        }
    }

    public static synchronized void a(boolean z, int i, int i2) {
        synchronized (e.class) {
            if (z) {
                if (i2 < c) {
                    a();
                } else {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    if (c == 0 && b == 0) {
                        c = i2;
                        b = elapsedRealtime;
                    } else {
                        int i3 = i2 - c;
                        if (i3 > 0) {
                            a(a.size(), b, i3, elapsedRealtime);
                            c = i2;
                            b = elapsedRealtime;
                        }
                    }
                }
            }
        }
    }

    private static long b() {
        int size = a.size();
        if (size <= 0) {
            return -1;
        }
        long j = 0;
        for (int i = 0; i < size; i++) {
            j += ((Long) a.elementAt(i)).longValue();
        }
        return j / ((long) size);
    }
}
