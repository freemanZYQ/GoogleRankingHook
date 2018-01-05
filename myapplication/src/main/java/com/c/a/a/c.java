package com.c.a.a;

import android.util.Log;
import com.c.a.c.a;

class c implements a {
    final /* synthetic */ com.c.a.f.a.a a;
    final /* synthetic */ b b;

    c(b bVar, com.c.a.f.a.a aVar) {
        this.b = bVar;
        this.a = aVar;
    }

    public void a() {
        if (this.a != null) {
            try {
                this.a.a("{\"result\":false}");
            } catch (Exception e) {
                Log.d("AppLink", e.toString());
            }
        }
    }

    public void a(com.c.a.c.a.a aVar) {
        if (this.a != null) {
            try {
                this.a.a(String.format("{\"result\":true,\"mixedNick\":\"%s\",\"icon\":\"%s\"}", new Object[]{aVar.b, aVar.c}));
            } catch (Exception e) {
                Log.d("AppLink", e.toString());
            }
        }
    }
}
