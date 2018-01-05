package com.inveno.se.c;

import android.content.Context;
import com.inveno.a.f;
import com.inveno.a.l;
import com.inveno.se.e.c;
import com.inveno.se.f.j;
import com.inveno.se.f.k;
import java.io.File;
import java.util.Vector;
import org.json.JSONObject;

public class a {
    private static a a;
    private int b;
    private Vector c;
    private boolean d;
    private String e;

    private a(Context context) {
        try {
            this.e = new JSONObject(k.c(j.a(context, "config" + File.separator + "adam"))).getString("uid");
            if (k.a(com.inveno.se.model.a.a(context).a())) {
                com.inveno.se.model.a.a(context).a(this.e);
            }
            l.a().q(this.e);
        } catch (Exception e) {
            com.inveno.se.f.a.b("获取本地uid失败 ：" + e.getMessage());
        }
        this.c = new Vector(3);
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a(context);
            }
            aVar = a;
        }
        return aVar;
    }

    private void b(Context context) {
        f.a(new b(this, context));
    }

    public void a(c cVar, Context context) {
        if (cVar != null && !this.c.contains(cVar)) {
            this.c.add(cVar);
            if (!this.d) {
                this.d = true;
                b(context);
            }
        }
    }

    public boolean a() {
        if (k.a(com.inveno.se.c.a()) && k.b(this.e)) {
            com.inveno.se.c.a(this.e);
        }
        return !k.a(this.e);
    }

    public String b() {
        return this.e;
    }
}
