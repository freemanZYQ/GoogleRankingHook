package com.b.e;

import android.content.Context;
import com.b.a.d;
import com.b.c.c;
import com.moxiu.a.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a extends c {
    Map i = new HashMap();

    public a(Context context, String str, int i, com.moxiu.b.b.a aVar) {
        this.h = context;
        this.e = str;
        this.f = i;
        this.d = aVar;
    }

    private void a(Context context, com.moxiu.b.a.a aVar, com.moxiu.b.b.a aVar2) {
        if (!this.i.containsKey("ade")) {
            this.i.put("ade", new d(aVar));
            com.moxiu.gdlibrary.a.a(context, aVar, aVar2);
        }
    }

    private synchronized void a(List list, com.moxiu.b.a.a aVar) {
        List o = aVar.o();
        aVar.R = 0;
        if (o != null && o.size() > 0 && ("ade".equals(aVar.C) || "baidu".equals(aVar.C))) {
            for (int i = 0; i < list.size(); i++) {
                if (aVar.C.equals(((com.moxiu.b.a.a) list.get(i)).C)) {
                    if (aVar.R < o.size()) {
                        list.set(i, o.get(aVar.R));
                        aVar.R++;
                    } else {
                        ((com.moxiu.b.a.a) list.get(i)).S = false;
                    }
                    if (i == list.size() - 1 && aVar.R < o.size()) {
                        for (int i2 = aVar.R; i2 < o.size(); i2++) {
                            list.add(o.get(i2));
                        }
                    }
                }
            }
        }
        if (this.i.containsKey(aVar.C)) {
            this.i.remove(aVar.C);
        }
        c(list);
    }

    private void b(Context context, com.moxiu.b.a.a aVar, com.moxiu.b.b.a aVar2) {
        if (!this.i.containsKey("baidu")) {
            this.i.put("baidu", new d(aVar));
            b.a(context, aVar, aVar2);
        }
    }

    private void b(List list) {
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                String str = ((com.moxiu.b.a.a) list.get(i)).C;
                ((com.moxiu.b.a.a) list.get(i)).L = i;
                if ("ade".equals(str)) {
                    a(this.h, (com.moxiu.b.a.a) list.get(i), new c(this));
                } else if ("baidu".equals(str)) {
                    b(this.h, (com.moxiu.b.a.a) list.get(i), new b(this));
                } else if (!"mad".equals(str) && "dianou".equals(str)) {
                }
            }
            c(list);
        }
    }

    private void c(List list) {
        if (this.i.size() == 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!((com.moxiu.b.a.a) it.next()).S) {
                    it.remove();
                }
            }
            com.moxiu.b.d.c.b("list ad loaded ===>" + list + " time==>" + System.currentTimeMillis());
            if (this.d != null) {
                this.d.a(list);
            }
            if (this.c != null) {
                this.c.removeMessages(1360);
            }
        }
    }

    public void a() {
        if (this.g == null || this.g.size() <= 0) {
            if (this.d != null) {
                this.d.a(0, "no ad");
                com.moxiu.b.d.c.b("final return list no ad ===> time==>" + System.currentTimeMillis());
            }
        } else if (this.d != null) {
            Iterator it = this.g.iterator();
            while (it.hasNext()) {
                if (!((com.moxiu.b.a.a) it.next()).S) {
                    it.remove();
                }
            }
            if (this.g.size() > 0) {
                if (this.d != null) {
                    this.d.a(this.g);
                }
                com.moxiu.b.d.c.b("final return list ad loaded ===>" + this.g + " time==>" + System.currentTimeMillis());
            } else {
                if (this.d != null) {
                    this.d.a(0, "no ad");
                }
                com.moxiu.b.d.c.b("final return list no ad ===> time==>" + System.currentTimeMillis());
            }
        }
        if (this.c != null) {
            this.c.removeMessages(1360);
        }
    }

    public void a(List list) {
        if (this.c != null) {
            this.c.sendEmptyMessageDelayed(1360, 8000);
        }
        if (list == null || list.size() <= 0) {
            a();
            return;
        }
        this.g = list;
        b(this.g);
    }
}
