package com.vlocker.weather.e;

import android.text.TextUtils;
import com.moxiu.b.b.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class g implements a {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public void a(int i, String str) {
        this.a.b.add(this.a.d());
        this.a.b.add(this.a.d());
        this.a.c();
        this.a.j.a();
    }

    public void a(com.moxiu.b.a.a aVar) {
    }

    public void a(List list) {
        if (list != null && list.size() > 0) {
            Collection arrayList;
            if (list.size() == 1) {
                int i = ("5804550b25a6805c7e8b4568".equals(((com.moxiu.b.a.a) list.get(0)).B) || "58008ec80c04b43f2f8b52cf".equals(((com.moxiu.b.a.a) list.get(0)).B)) ? 0 : 1;
                list.add(i, this.a.d());
            }
            if (list.size() > 2) {
                arrayList = new ArrayList(list.subList(0, 2));
            }
            this.a.b.addAll(arrayList);
            if (!TextUtils.isEmpty(this.a.d)) {
                this.a.c();
            }
            this.a.j.a();
        }
    }
}
