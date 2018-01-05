package com.alimama.ad.mobile.login.a;

import android.content.Context;
import android.text.TextUtils;
import com.c.a.b;
import com.c.a.c;

public class a {
    private static a a = new a();

    private a() {
    }

    public static a a() {
        return a;
    }

    public void a(com.alimama.ad.mobile.b.a aVar) {
        if (aVar != null) {
            String b = aVar.b("appKey");
            String b2 = aVar.b("appSecret");
            String b3 = aVar.b("backUrl");
            String b4 = aVar.b("pid");
            Object b5 = aVar.b("failedMode");
            b.a().a(new com.c.a.a(b, b2, b3, b4));
            if (!TextUtils.isEmpty(b5) && b5.trim().equals("openH5")) {
                b.a().a(c.OPEN_H5);
            } else if (!TextUtils.isEmpty(b5) && b5.trim().equals("downloadTB")) {
                b.a().a(c.DOWNLOAD_TAOBAO);
            }
        }
    }

    public void b(com.alimama.ad.mobile.b.a aVar) {
        if (aVar != null) {
            Object b = aVar.b("url");
            Object b2 = aVar.b("backUrl");
            Context context = (Context) aVar.c("appContext");
            if (!TextUtils.isEmpty(b)) {
                com.c.a.g.c cVar = new com.c.a.g.c(b);
                if (!TextUtils.isEmpty(b2)) {
                    cVar.a((String) b2);
                }
                try {
                    b.a().a(context, cVar);
                } catch (com.c.a.e.a e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
