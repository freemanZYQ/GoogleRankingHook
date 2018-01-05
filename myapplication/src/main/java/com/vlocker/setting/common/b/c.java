package com.vlocker.setting.common.b;

import android.os.Message;

final class c extends Thread {
    public boolean a = false;
    final /* synthetic */ b b;

    public c(b bVar) {
        this.b = bVar;
    }

    private final boolean a(d dVar) {
        boolean z = true;
        Message a = dVar.b();
        switch (dVar.c) {
            case 1:
                z = dVar.b.a(a);
                break;
            case 2:
                z = dVar.b.b(a);
                break;
            case 4:
                z = dVar.b.c(a);
                break;
            case 8:
                z = dVar.b.d(a);
                break;
        }
        if (z) {
            dVar.a();
        }
        return z;
    }

    public final void a() {
        this.a = true;
    }

    public final void run() {
        while (!this.a && this.b.c != null && !this.b.c.isEmpty()) {
            int i = 0;
            while (this.b.c != null && i < this.b.c.size()) {
                try {
                    int i2;
                    if (a((d) this.b.c.get(i))) {
                        this.b.c.remove(i);
                        i2 = i - 1;
                    } else {
                        i2 = i;
                    }
                    i = i2 + 1;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            sleep(100);
        }
        this.a = true;
        this.b.b = null;
    }
}
