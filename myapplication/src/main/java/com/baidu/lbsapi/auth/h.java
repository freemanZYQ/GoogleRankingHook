package com.baidu.lbsapi.auth;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class h implements X509TrustManager {
    final /* synthetic */ f a;
    final /* synthetic */ b b;

    h(b bVar, f fVar) {
        this.b = bVar;
        this.a = fVar;
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
