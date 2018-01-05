package com.inveno.se.b;

import android.content.Context;
import com.inveno.a.ai;
import com.inveno.a.au;
import com.inveno.se.d.a.t;
import com.inveno.se.d.s;
import com.inveno.se.f.a;
import java.util.Map;

public class b implements au {
    private static b b;
    public s a;

    public b(Context context) {
        try {
            this.a = t.a(context.getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
            a.a("pise", " VolleyHttp init error:" + e.getMessage());
            this.a = t.a(context);
        }
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new b(context);
            }
            bVar = b;
        }
        return bVar;
    }

    public void a(String str, Map map, ai aiVar) {
        a.b("访问的url：" + str);
        this.a.a(new a(str, new c(this, aiVar), new d(this, aiVar), map, false));
        this.a.a();
    }
}
