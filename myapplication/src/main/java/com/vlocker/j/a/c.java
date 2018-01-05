package com.vlocker.j.a;

import java.util.Comparator;

final class c implements Comparator {
    c() {
    }

    public int a(f fVar, f fVar2) {
        return fVar.a > fVar2.a ? 1 : fVar.a == fVar2.a ? 0 : -1;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((f) obj, (f) obj2);
    }
}
