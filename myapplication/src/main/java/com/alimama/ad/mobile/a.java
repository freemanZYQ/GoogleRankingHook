package com.alimama.ad.mobile;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class a {
    private static a a = new a();
    private int b;
    private String c;
    private String d;

    private a() {
    }

    public static a a() {
        return a;
    }

    private com.alimama.ad.mobile.b.a c(com.alimama.ad.mobile.b.a aVar) {
        String b = aVar.b("url");
        if (!(TextUtils.isEmpty(b) || TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d))) {
            try {
                URL url = new URL(b);
                String encode = URLEncoder.encode("appkey=" + this.c + "&backURL=" + this.d, "UTF-8");
                aVar.a("url", !TextUtils.isEmpty(url.getQuery()) ? b + "&a=" + encode : b + "?a=" + encode);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return aVar;
    }

    public void a(com.alimama.ad.mobile.b.a aVar) {
        if (aVar != null) {
            this.b = aVar.a("login");
            this.c = aVar.b("appKey");
            this.d = aVar.b("backUrl");
            switch (this.b) {
                case 1:
                    com.alimama.ad.mobile.login.inapp.a.a().a(aVar);
                    return;
                case 2:
                    com.alimama.ad.mobile.login.a.a.a().a(aVar);
                    return;
                case 3:
                    com.alimama.ad.mobile.login.inapp.a.a().a(aVar);
                    com.alimama.ad.mobile.login.a.a.a().a(aVar);
                    return;
                default:
                    return;
            }
        }
    }

    public void b(com.alimama.ad.mobile.b.a aVar) {
        if (aVar != null) {
            this.b = aVar.a("login") == -1 ? this.b : aVar.a("login");
            this.d = aVar.b("backUrl");
            switch (this.b) {
                case 1:
                    com.alimama.ad.mobile.login.inapp.a.a().b(aVar);
                    return;
                case 2:
                    com.alimama.ad.mobile.login.a.a.a().b(c(aVar));
                    return;
                default:
                    return;
            }
        }
    }
}
