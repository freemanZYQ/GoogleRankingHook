package com.vlocker.new_theme.a;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

class f implements HttpRequestInterceptor {
    final /* synthetic */ d a;

    f(d dVar) {
        this.a = dVar;
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
