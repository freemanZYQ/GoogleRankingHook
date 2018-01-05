package com.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.b.e.d;

public class a extends com.b.c.a {
    private d a;

    public a(Context context) {
        try {
            this.a = new d(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public a a(String str, int i, com.moxiu.b.b.a aVar) {
        if (!(TextUtils.isEmpty(str) || aVar == null)) {
            this.a.a(str, i, aVar);
        }
        return this;
    }

    public void a() {
        if (this.a != null) {
            this.a.a();
        }
    }
}
