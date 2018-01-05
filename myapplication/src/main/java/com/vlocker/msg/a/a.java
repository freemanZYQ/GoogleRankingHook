package com.vlocker.msg.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.vlocker.b.j;
import com.vlocker.b.p;
import com.vlocker.msg.as;
import java.util.List;

public class a {
    private static a g = null;
    private Context a;
    private com.moxiu.b.a.a b;
    private List c;
    private com.vlocker.c.a d;
    private long e = 10800000;
    private int f = 0;
    private boolean h = false;
    private int i;

    private a(Context context) {
        this.a = context;
        this.d = com.vlocker.c.a.a(this.a);
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (g == null) {
                g = new a(context);
            }
            aVar = g;
        }
        return aVar;
    }

    private void d() {
        this.h = false;
        this.f++;
        if (this.c == null || this.f >= this.c.size()) {
            this.b = null;
            return;
        }
        this.b = (com.moxiu.b.a.a) this.c.get(this.f);
        this.b.a(false);
        c.a(this.a, this.b);
    }

    private void e() {
        this.i = this.d.d();
        if (as.a(System.currentTimeMillis(), this.d.e())) {
            this.i++;
        } else {
            this.i = 1;
        }
        this.d.a(this.i);
        this.d.a(System.currentTimeMillis());
        new com.b.b.a(this.a).a(com.b.d.a.b(this.a, "message_push"), 10, new b(this)).a();
    }

    public void a() {
        if (!as.b() && System.currentTimeMillis() - this.d.e() > this.e && j.f(this.a)) {
            e();
        } else if (this.h) {
            d();
        }
    }

    public void a(String str) {
        if (this.b != null) {
            View view = new View(this.a);
            view.setLayoutParams(new LayoutParams(200, 200));
            com.vlocker.b.a.a(this.a, this.b, view, "", null, false, null);
            p.a(this.a, "Vlock_Open_MsgAD_PPC_TF", "msg_name", this.b.h(), "from", str);
        }
    }

    public void b() {
        this.h = true;
    }

    public void c() {
        this.h = true;
    }
}
