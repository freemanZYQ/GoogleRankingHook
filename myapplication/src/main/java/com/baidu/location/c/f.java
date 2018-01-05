package com.baidu.location.c;

import java.util.List;
import java.util.concurrent.Callable;

class f implements Callable {
    final /* synthetic */ String a;
    final /* synthetic */ List b;
    final /* synthetic */ d c;

    f(d dVar, String str, List list) {
        this.c = dVar;
        this.a = str;
        this.b = list;
    }

    public String a() {
        this.c.a(this.a, this.b);
        return this.c.b(true);
    }

    public /* synthetic */ Object call() {
        return a();
    }
}
