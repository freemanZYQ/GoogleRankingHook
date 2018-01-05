package com.vlocker.splash.newa;

import android.content.Context;
import android.os.Handler;
import com.b.b.b;
import com.b.d.a;
import java.util.List;

public class e implements c {
    Context a;
    List b;
    d c;
    Handler d;

    public e(Object obj, Handler handler) {
        this.a = (Context) obj;
        this.c = (d) obj;
        this.d = handler;
    }

    public void a() {
        new b(this.a, a.b(this.a, "vlocker_splash"), new f(this)).a();
    }
}
