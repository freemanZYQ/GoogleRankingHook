package com.vlocker.battery.saver;

import com.moxiu.b.b.a;
import java.util.ArrayList;
import java.util.List;

class d implements a {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public void a(int i, String str) {
    }

    public void a(com.moxiu.b.a.a aVar) {
        this.a.i();
    }

    public void a(List list) {
        List arrayList = new ArrayList();
        arrayList.addAll(list);
        this.a.k = arrayList;
        if (this.a.k != null && this.a.k.size() > 0) {
            this.a.c();
            this.a.l = (com.moxiu.b.a.a) this.a.k.get(0);
            this.a.l.a(false);
            this.a.f();
        }
    }
}
