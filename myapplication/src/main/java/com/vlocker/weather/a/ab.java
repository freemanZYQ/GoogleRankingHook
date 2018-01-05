package com.vlocker.weather.a;

import com.moxiu.b.b.a;
import java.util.ArrayList;
import java.util.List;

class ab implements a {
    final /* synthetic */ y a;

    ab(y yVar) {
        this.a = yVar;
    }

    public void a(int i, String str) {
        this.a.F = null;
        this.a.E = null;
        this.a.G.setVisibility(8);
    }

    public void a(com.moxiu.b.a.a aVar) {
        this.a.j();
    }

    public void a(List list) {
        List arrayList = new ArrayList();
        arrayList.addAll(list);
        this.a.E = arrayList;
        if (this.a.E != null && this.a.E.size() > 0) {
            this.a.F = (com.moxiu.b.a.a) this.a.E.get(0);
            this.a.F.a(false);
            this.a.I = 0;
            this.a.H = System.currentTimeMillis();
            this.a.d();
        }
    }
}
