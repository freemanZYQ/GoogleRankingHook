package com.inveno.se.d.a;

import com.inveno.se.f.a;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

class n implements HostnameVerifier {
    final /* synthetic */ l a;

    n(l lVar) {
        this.a = lVar;
    }

    public boolean verify(String str, SSLSession sSLSession) {
        a.a("Warning: URL Host: " + str + " vs. " + sSLSession.getPeerHost());
        return true;
    }
}
