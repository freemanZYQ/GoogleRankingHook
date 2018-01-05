package com.moxiu.b.c;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

class t implements HttpRequestInterceptor {
    final /* synthetic */ r a;

    t(r rVar) {
        this.a = rVar;
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        if (!httpRequest.containsHeader("Accept-Encoding")) {
            httpRequest.addHeader("Accept-Encoding", "gzip");
        }
        for (String str : this.a.h.keySet()) {
            httpRequest.addHeader(str, (String) this.a.h.get(str));
        }
    }
}
