package com.inveno.se;

import a.a;
import android.content.Context;
import com.inveno.a.an;
import com.inveno.a.i;
import com.inveno.se.a.f;
import com.inveno.se.f.e;
import com.inveno.se.f.k;
import com.inveno.se.f.m;
import java.util.Locale;

public class b {
    static String a;

    public static void a(Context context) {
        a(context, f.a, f.b, f.c, f.d);
    }

    public static void a(Context context, String str, int i, int[] iArr, int[] iArr2, int[] iArr3, com.inveno.se.e.b bVar) {
        if (iArr == null || iArr.length == 0 || iArr2 == null || iArr2.length == 0 || iArr3 == null || iArr3.length == 0) {
            throw new RuntimeException("contentType or display or linkType can not be null !");
        }
        d.a(context).a(context, str, i, com.inveno.se.model.b.a(iArr), com.inveno.se.model.b.a(iArr2), com.inveno.se.model.b.a(iArr3), bVar, 3);
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        if (k.a(str3) || k.a(str4)) {
            throw new RuntimeException("appKey or appSecret can not be null ! ");
        }
        if (!a.c) {
            e.c(context);
        }
        e.a(context);
        if (k.a(a)) {
            String language = Locale.getDefault().getLanguage();
            a = language + "_" + Locale.getDefault().getCountry();
        }
        com.inveno.se.c.a.a(context);
        an.a(false);
        i.a("3.0.2");
        i.b(m.b("upack", "", context));
        i.a(context, str, str2, com.inveno.se.f.b.b, a, str3, str4, com.inveno.se.b.b.a(context));
    }

    public static void a(String str) {
        a = str;
    }

    public static void b(Context context, String str, int i, int[] iArr, int[] iArr2, int[] iArr3, com.inveno.se.e.b bVar) {
        if (iArr == null || iArr.length == 0 || iArr2 == null || iArr2.length == 0 || iArr3 == null || iArr3.length == 0) {
            throw new RuntimeException("contentType or display or linkType can not be null !");
        }
        d.a(context).a(context, str, i, com.inveno.se.model.b.a(iArr), com.inveno.se.model.b.a(iArr2), com.inveno.se.model.b.a(iArr3), bVar, 2);
    }
}
