package com.mx.http;

import android.content.Context;
import java.util.Map;

public class n extends j {
    private g b;

    public n(String str, int i, Map map, String str2, Context context, g gVar) {
        super(str, i, map, str2, context);
        this.b = gVar;
    }

    void a(i iVar) {
        if (iVar.a() != null) {
            this.b.a(iVar.a().toString());
        }
    }
}
