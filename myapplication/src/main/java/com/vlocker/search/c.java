package com.vlocker.search;

import com.moxiu.b.b.a;
import java.util.ArrayList;
import java.util.List;

class c implements a {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void a(int i, String str) {
        this.a.l = null;
        this.a.k = null;
        this.a.b(true);
    }

    public void a(com.moxiu.b.a.a aVar) {
        this.a.g();
    }

    public void a(List list) {
        List arrayList = new ArrayList();
        arrayList.addAll(list);
        this.a.k = arrayList;
        if (this.a.k != null && this.a.k.size() > 0) {
            this.a.l = (com.moxiu.b.a.a) this.a.k.get(0);
            this.a.l.a(false);
            this.a.o = 0;
            this.a.n = System.currentTimeMillis();
            this.a.b();
        }
    }
}
