package com.b.e;

import android.content.Context;
import com.b.c.b;
import com.moxiu.b.b.a;
import com.moxiu.b.d.c;
import java.util.ArrayList;
import java.util.List;

public class g extends b {
    Context d;
    String e;
    a f;
    List g = new ArrayList();
    String h;

    public g(Context context, String str, a aVar) {
        this.e = c.a(context, str);
        this.d = context;
        this.h = str;
        this.f = aVar;
    }

    private void a(String str, List list) {
        List arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                ((com.moxiu.b.a.a) list.get(i)).L = i;
                if (i > 1) {
                    break;
                }
                arrayList.add(list.get(i));
            }
        }
        b(str, arrayList);
    }

    private void b(String str, List list) {
        c.a("debug", "listener-->" + this.f + " adBeans-->" + list + " placeId-->" + str);
        if (this.f != null && list != null && list.size() > 0 && str != null && str.length() > 0) {
            this.f.a(list);
        } else if (this.f != null) {
            this.f.a(0, "no ad");
            c.a("debug", "splash no ad-->" + str);
        }
    }

    public void a() {
        try {
            c.a("debug", "splash url-->" + this.e);
            this.c.a(this.e, new h(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
