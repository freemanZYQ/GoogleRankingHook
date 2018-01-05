package com.vlocker.weather.a;

import android.util.Log;
import com.moxiu.b.b.a;
import java.util.List;

class aj implements a {
    final /* synthetic */ ah a;

    aj(ah ahVar) {
        this.a = ahVar;
    }

    public void a(int i, String str) {
        this.a.d.setVisibility(8);
        this.a.i.setVisibility(8);
    }

    public void a(com.moxiu.b.a.a aVar) {
    }

    public void a(List list) {
        if (list == null || list.size() <= 0) {
            this.a.d.setVisibility(8);
            this.a.i.setVisibility(8);
            return;
        }
        Log.e("locker", "icon loaded-->" + System.currentTimeMillis());
        ah.j = (com.moxiu.b.a.a) list.get(0);
        ah.k = ah.j.m();
        ah.l = ah.j.n();
        this.a.f();
    }
}
