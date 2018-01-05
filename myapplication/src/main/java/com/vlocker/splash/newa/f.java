package com.vlocker.splash.newa;

import com.moxiu.b.b.a;
import java.util.List;

class f implements a {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public void a(int i, String str) {
        if (this.a.d != null) {
            this.a.d.sendEmptyMessageDelayed(40, 1000);
        }
    }

    public void a(com.moxiu.b.a.a aVar) {
    }

    public void a(List list) {
        this.a.b = list;
        if (this.a.c == null) {
            return;
        }
        if (this.a.b != null && this.a.b.size() > 0) {
            this.a.c.a(this.a.b);
        } else if (this.a.d != null) {
            this.a.d.sendEmptyMessageDelayed(40, 1000);
        }
    }
}
