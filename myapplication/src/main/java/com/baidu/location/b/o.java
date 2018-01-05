package com.baidu.location.b;

import com.baidu.location.b.j.a;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

class o implements X509TrustManager {
    final /* synthetic */ a a;

    o(a aVar) {
        this.a = aVar;
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}
