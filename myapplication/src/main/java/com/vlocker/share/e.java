package com.vlocker.share;

import java.util.Comparator;

class e implements Comparator {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public int a(f fVar, f fVar2) {
        return fVar.a - fVar2.a;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((f) obj, (f) obj2);
    }
}
