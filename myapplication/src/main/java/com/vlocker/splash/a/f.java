package com.vlocker.splash.a;

import android.os.Handler;
import android.view.ViewGroup;
import com.b.f.b;
import com.vlocker.splash.newa.a;

public class f extends a {
    com.moxiu.b.a.a a;
    Handler b;

    public f(ViewGroup viewGroup, com.moxiu.b.a.a aVar, Handler handler) {
        this.a = aVar;
        this.b = handler;
        this.a.Q = viewGroup;
    }

    private void b(com.moxiu.b.a.a aVar) {
        b.b(this.f, aVar, new g(this));
    }

    private void c() {
        this.b.sendEmptyMessageDelayed(40, 3000);
    }

    public void a() {
        b(this.a);
        a(this.a);
    }
}
