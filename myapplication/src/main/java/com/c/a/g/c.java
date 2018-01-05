package com.c.a.g;

import android.content.Context;
import com.c.a.e.a;
import com.c.a.e.b;

public class c extends b {
    private String e;

    private c() {
    }

    public c(String str) {
        this.a.put("module", "h5");
        this.e = str;
    }

    public String a() {
        if (com.c.a.k.c.b(this.e)) {
            return super.b(this.e);
        }
        throw new a(b.H5URL_ILLEGAL);
    }

    public String b(Context context) {
        if (com.c.a.k.c.b(this.e)) {
            this.a.put("h5Url", this.e);
            return super.b(context);
        }
        throw new a(b.H5URL_ILLEGAL);
    }
}
