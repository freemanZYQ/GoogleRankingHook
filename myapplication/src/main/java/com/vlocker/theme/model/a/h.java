package com.vlocker.theme.model.a;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

class h implements HttpRequestInterceptor {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        if (!httpRequest.containsHeader("Accept-Encoding")) {
            httpRequest.addHeader("Accept-Encoding", "gzip");
        }
        for (String str : this.a.m.keySet()) {
            httpRequest.addHeader(str, (String) this.a.m.get(str));
        }
    }
}
