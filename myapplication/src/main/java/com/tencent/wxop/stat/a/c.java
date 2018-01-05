package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.d;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.y;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import org.json.JSONObject;

public final class c extends d {
    private String a;
    private int m;
    private int n = 100;
    private Thread o = null;

    public c(Context context, int i, Throwable th, y yVar) {
        super(context, i, yVar);
        a(99, th);
    }

    public c(Context context, int i, Throwable th, Thread thread) {
        super(context, i, null);
        a(2, th);
        this.o = thread;
    }

    private void a(int i, Throwable th) {
        if (th != null) {
            Writer stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            this.a = stringWriter.toString();
            this.m = i;
            printWriter.close();
        }
    }

    public final boolean a(JSONObject jSONObject) {
        r.a(jSONObject, "er", this.a);
        jSONObject.put("ea", this.m);
        if (this.m == 2 || this.m == 3) {
            new d(this.l).a(jSONObject, this.o);
        }
        return true;
    }

    public final e b() {
        return e.ERROR;
    }
}
