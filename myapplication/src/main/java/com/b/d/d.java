package com.b.d;

import android.content.Context;
import com.moxiu.b.c.n;
import com.moxiu.b.d.b;

final class d extends n {
    final /* synthetic */ Context a;

    d(Context context) {
        this.a = context;
    }

    public void a(String str) {
        super.a(str);
        if (str != null && str.length() > 10) {
            b.c(this.a, "preload_sharename", str);
        }
    }

    public void a(Throwable th, int i, String str) {
        super.a(th, i, str);
        b.c(this.a, "preload_sharename", "");
    }
}
