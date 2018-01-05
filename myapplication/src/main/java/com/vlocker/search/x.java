package com.vlocker.search;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.moxiu.b.a.a;
import com.vlocker.theme.model.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class x {
    private static x f = null;
    public List a = new ArrayList();
    public List b = new ArrayList();
    public a c;
    public a d;
    private Context e;
    private d g;

    public x(Context context) {
        this.e = context;
    }

    public static synchronized x a(Context context) {
        x xVar;
        synchronized (x.class) {
            if (f == null) {
                f = new x(context);
            }
            xVar = f;
        }
        return xVar;
    }

    public a a(String str) {
        a aVar;
        if ("from_search_edit".equals(str)) {
            if (this.a == null || this.a.size() <= 0) {
                return null;
            }
            aVar = (a) this.a.get(new Random().nextInt(this.a.size()));
            this.c = aVar;
            return aVar;
        } else if (!"from_search".equals(str) || this.b == null || this.b.size() <= 0) {
            return null;
        } else {
            aVar = (a) this.b.get(new Random().nextInt(this.b.size()));
            this.d = aVar;
            return aVar;
        }
    }

    public void a() {
        this.g = new d();
        new com.b.b.a(this.e.getApplicationContext()).a(com.b.d.a.b(this.e, "search_hot_words"), 50, new y(this)).a();
    }

    public void a(View view, a aVar) {
        Log.e("zzx", "onClick: ");
        if (aVar != null) {
            Log.e("zzx", "onClick: start");
            aVar.a(false);
            com.vlocker.b.a.a(this.e, aVar, view, "search", null, false, null);
        }
    }
}
