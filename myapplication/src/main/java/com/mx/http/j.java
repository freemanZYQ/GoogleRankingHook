package com.mx.http;

import android.content.Context;
import com.mx.http.download.a;
import java.util.Map;

public abstract class j implements Comparable {
    protected static Context a;
    private String b;
    private int c = 0;
    private Map d;
    private a e;
    private Integer f = Integer.valueOf(0);
    private boolean g;
    private boolean h;
    private String i;
    private boolean j;
    private boolean k = true;

    public j(String str, int i, Map map, String str2, Context context) {
        this.b = str;
        this.c = i;
        this.d = map;
        this.i = str2;
        a = context;
    }

    public j(String str, a aVar) {
        this.b = str;
        this.e = aVar;
    }

    public int a(j jVar) {
        k i = i();
        k i2 = jVar.i();
        return i == i2 ? this.f.intValue() - jVar.f.intValue() : i2.ordinal() - i.ordinal();
    }

    public void a(Context context) {
        a = context;
    }

    abstract void a(i iVar);

    public void a(boolean z) {
        this.h = z;
    }

    public boolean b() {
        return this.j;
    }

    public Context c() {
        return a;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return a((j) obj);
    }

    public boolean d() {
        return this.h;
    }

    public String e() {
        return this.b;
    }

    public Map f() {
        return this.d;
    }

    public int g() {
        return this.c;
    }

    public boolean h() {
        return this.g;
    }

    public k i() {
        return k.NORMAL;
    }
}
