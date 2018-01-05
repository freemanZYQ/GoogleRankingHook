package com.baidu.lbsapi.auth;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class e implements X509TrustManager {
    final /* synthetic */ c a;
    final /* synthetic */ b b;

    e(b bVar, c cVar) {
        this.b = bVar;
        this.a = cVar;
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
