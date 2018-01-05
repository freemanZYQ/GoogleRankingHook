package com.inveno.se.d.a;

import com.inveno.se.f.a;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class o implements X509TrustManager {
    final /* synthetic */ l a;

    o(l lVar) {
        this.a = lVar;
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        a.a("cert: " + x509CertificateArr[0].toString() + ", authType: " + str);
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
