package com.inveno.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

class ae {
    private static Map a = new HashMap();
    private static Map b = new HashMap();
    private static Map c = new HashMap();

    private static String a(String str, String str2) {
        return String.format("%s_%s", new Object[]{str, str2});
    }

    static void a(String str, long j) {
        d.a().c();
        if (!TextUtils.isEmpty(str)) {
            a.put(str, new ad(str, j));
        }
    }

    static void a(String str, String str2, long j, int i) {
        d.a().c();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            b.put(a(str, str2), new y(str, str2, j, i));
        }
    }

    static void a(String str, String str2, String str3, long j, String str4, String str5, long j2) {
        d.a().c();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str3 != null) {
            if ("0x0308ff".equalsIgnoreCase(str)) {
                as.a().a(new ab(str, str2, str3, j2, j, null, null));
                return;
            }
            x abVar = new ab(str, str2, str3, j2, j, str4, str5);
            if (!r.a().a(abVar)) {
                af.a().a(abVar.a());
            }
        }
    }

    static void a(String str, String str2, String str3, String str4, String str5, long j) {
        d.a().c();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str3 != null) {
            String a = a(str, str2);
            y yVar = (y) b.get(a);
            if (yVar != null) {
                yVar.a(str3).b(str4).c(str5).a(j);
                af.a().a(yVar.a().a());
                af.a().a(yVar.b().a());
                b.remove(a);
            }
            as.a().a(3);
        }
    }

    static void a(String str, String str2, String str3, boolean z, String str4, String str5, long j) {
        d.a().c();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str3 != null) {
            if ("0x0308ff".equalsIgnoreCase(str)) {
                as.a().a(new w(str, str2, str3, j, z, null, null));
                return;
            }
            x wVar = new w(str, str2, str3, j, z, str4, str5);
            if (!r.a().a(wVar)) {
                af.a().a(wVar.a());
            }
            as.a().a(2);
        }
    }

    static void b(String str, long j) {
        d.a().c();
        if (!TextUtils.isEmpty(str)) {
            ad adVar = (ad) a.get(str);
            if (adVar != null) {
                adVar.a(j);
                af.a().a(adVar.a().a());
                a.remove(str);
            }
            as.a().a(1);
        }
    }
}
