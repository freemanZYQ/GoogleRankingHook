package com.vlocker.search;

import com.moxiu.b.b.a;
import java.util.List;

class ay implements a {
    final /* synthetic */ ax a;

    ay(ax axVar) {
        this.a = axVar;
    }

    public void a(int i, String str) {
        this.a.c().setVisibility(8);
        this.a.b = false;
    }

    public void a(com.moxiu.b.a.a aVar) {
    }

    public void a(List list) {
        this.a.a.clear();
        this.a.a.addAll(list);
        if (this.a.a == null || this.a.a.size() <= 0) {
            this.a.c().setVisibility(8);
        } else {
            this.a.c().setVisibility(0);
            this.a.d();
        }
        this.a.b = true;
    }
}
