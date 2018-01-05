package com.vlocker.new_theme.a;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

class g implements HttpResponseInterceptor {
    final /* synthetic */ d a;

    g(d dVar) {
        this.a = dVar;
    }

    public void process(HttpResponse httpResponse, HttpContext httpContext) {
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            Header contentEncoding = entity.getContentEncoding();
            if (contentEncoding != null) {
                for (HeaderElement name : contentEncoding.getElements()) {
                    if (name.getName().equalsIgnoreCase("gzip")) {
                        httpResponse.setEntity(new h(httpResponse.getEntity()));
                        return;
                    }
                }
            }
        }
    }
}
