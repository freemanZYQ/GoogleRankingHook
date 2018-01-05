package com.inveno.se;

import android.content.Context;
import com.inveno.se.e.a;
import com.inveno.se.e.c;

class e implements c {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ int e;
    final /* synthetic */ int f;
    final /* synthetic */ a g;
    final /* synthetic */ int h;
    final /* synthetic */ d i;

    e(d dVar, Context context, String str, int i, int i2, int i3, int i4, a aVar, int i5) {
        this.i = dVar;
        this.a = context;
        this.b = str;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = aVar;
        this.h = i5;
    }

    public void a() {
        com.inveno.se.f.a.b("getNews getuid sucess,go to request ZZ LIST -------");
        this.i.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    public void b() {
        this.g.a("uid request error!");
    }
}
