package com.c.a.a;

import android.content.Context;
import com.c.a.f.a.a;

public abstract class d {
    public a b;

    public abstract void a();

    public abstract void a(Context context);

    public abstract void a(Context context, a aVar);

    public abstract void a(Exception exception);

    public void b(Context context, a aVar) {
        if (aVar != null) {
            a(context, aVar);
        } else {
            a(context);
        }
    }
}
