package com.b.e;

import com.moxiu.b.b.a;
import com.moxiu.b.d.c;
import java.util.List;

class b implements a {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void a(int i, String str) {
    }

    public void a(com.moxiu.b.a.a aVar) {
    }

    public void a(List list) {
        com.moxiu.b.a.a aVar = (com.moxiu.b.a.a) this.a.i.get("baidu");
        if (aVar != null) {
            aVar.b(list);
            this.a.a(this.a.g, aVar);
            c.a("greenlist", "list baidu loaded-->" + list.size() + " time-->" + System.currentTimeMillis());
        }
    }
}
