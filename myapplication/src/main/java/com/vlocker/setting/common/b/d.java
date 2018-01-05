package com.vlocker.setting.common.b;

import android.os.Handler;
import android.os.Message;

final class d {
    final /* synthetic */ b a;
    private a b;
    private int c;
    private Handler d;
    private Message e = new Message();

    public d(b bVar, a aVar, int i, Handler handler, int i2) {
        this.a = bVar;
        this.b = aVar;
        this.c = i;
        this.d = handler;
        this.e.what = i2;
    }

    private final void a() {
        if (this.d != null) {
            this.d.sendMessage(this.e);
        }
    }

    private final Message b() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(d.class)) {
            return false;
        }
        d dVar = (d) obj;
        return this.b.equals(dVar.b) && this.c == dVar.c;
    }

    public final int hashCode() {
        return (this.b.hashCode() * 7) + (this.c * 13);
    }
}
