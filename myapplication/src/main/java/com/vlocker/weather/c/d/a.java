package com.vlocker.weather.c.d;

import com.vlocker.weather.c.c.b;
import java.util.ArrayList;
import java.util.List;

public abstract class a {
    public int a;
    protected int b;
    protected b c;

    public abstract b a(Object obj, boolean z);

    protected ArrayList a(List list, boolean z) {
        if (z) {
            this.b = 0;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(a(list.get(i), ((this.b + i) + 1) % 8 == 0));
            }
            this.b += list.size();
        }
        return arrayList;
    }

    public abstract void a();

    public void a(b bVar) {
        this.c = bVar;
    }

    public abstract void b();

    public abstract void c();

    public abstract boolean d();

    public abstract void e();
}
