package com.vlocker.splash.a;

import android.os.Handler;
import android.view.ViewGroup;
import com.b.f.b;

public class a extends com.vlocker.splash.newa.a {
    com.moxiu.b.a.a a;
    Handler b;

    public a(ViewGroup viewGroup, com.moxiu.b.a.a aVar, Handler handler) {
        this.a = aVar;
        this.a.Q = viewGroup;
        this.b = handler;
    }

    private void b(com.moxiu.b.a.a aVar) {
        b.a(this.f, aVar, new b(this));
    }

    private void c() {
        this.b.sendEmptyMessageDelayed(40, 3000);
    }

    private void d() {
        this.b.sendEmptyMessage(49);
    }

    public void a() {
        b(this.a);
        a(this.a);
    }
}
