package com.b.e;

import android.content.Context;
import android.text.TextUtils;
import com.b.c.b;
import com.moxiu.b.b.a;
import com.moxiu.b.c.r;
import com.moxiu.b.d.c;
import java.util.ArrayList;
import java.util.List;

public class d extends b {
    public d(Context context) {
        this.a = context;
    }

    private void a(r rVar, a aVar) {
        String a = c.a(this.a, aVar.e);
        c.a("greenlist", "list LOADER-->" + a);
        rVar.a(a, new e(this, aVar));
    }

    private void a(r rVar, List list) {
        try {
            List arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(((a) list.get(i)).e);
            }
            rVar.a(c.a(this.a, arrayList), new f(this, list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a() {
        try {
            if (this.b.size() >= 1) {
                c.a("greenlist", "list load start-->" + System.currentTimeMillis());
                if (this.b.size() > 1) {
                    a(this.c, this.b);
                } else if (this.b.size() == 1) {
                    a(this.c, (a) this.b.get(0));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(String str, int i, a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            this.b.add(new a(this.a, str, i, aVar));
        }
    }
}
